package ucu.edu.ua.Task3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class PDLReader {
    public Company getCompanyData(String website) throws IOException {
        String API_KEY = "YOUR_PDL_API_KEY";
        URL url = new URL("https://api.peopledatalabs.com/v5/company/enrich?website=" + website);
        if (API_KEY == null || API_KEY.isEmpty()) {
            throw new IOException("API key is not set");
        }

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Api-Key", API_KEY);
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Failed to fetch company data: HTTP response code " + responseCode);
        }

        String text = new Scanner(connection.getInputStream()).useDelimiter("\\A").next();
        JSONObject jsonObject = new JSONObject(text);

        Company company = new Company();
        company.setName(jsonObject.optString("name", null));
        company.setDescription(jsonObject.optString("summary", null));
        company.setLogoUrl(jsonObject.optString("logo", null));

        return company;
    }
}
