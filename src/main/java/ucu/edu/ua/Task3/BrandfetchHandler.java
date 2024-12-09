package ucu.edu.ua.Task3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class BrandfetchHandler {
    private static final String API_KEY = "YOUR_BRANDFETCH_API_KEY";

    public Company getCompanyData(String domain) throws IOException {
        URL url = new URL("https://api.brandfetch.io/v2/brands/" + domain);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Failed to get data from Brandfetch. Response code: " + responseCode);
        }

        String text = new Scanner(connection.getInputStream()).useDelimiter("\\A").next();
        JSONObject jsonObject = new JSONObject(text);

        Company company = new Company();
        company.setName(jsonObject.optString("name", null));

        // Brandfetch may not provide description directly
        company.setDescription(null);

        // Get the logo URL
        if (jsonObject.has("logos")) {
            JSONArray logosArray = jsonObject.getJSONArray("logos");
            if (logosArray.length() > 0) {
                JSONObject logoObject = logosArray.getJSONObject(0);
                company.setLogoUrl(logoObject.optString("formats[0].src", null));
            }
        }

        return company;
    }
}