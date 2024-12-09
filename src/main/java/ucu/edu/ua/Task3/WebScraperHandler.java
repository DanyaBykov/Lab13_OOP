package ucu.edu.ua.Task3;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

public class WebScraperHandler {
    public Company getCompanyData(String website) throws IOException {
        Company company = new Company();

        Document doc = Jsoup.connect("https://" + website).get();

        // Extract company name from the title
        String title = doc.title();
        company.setName(title);

        // Extract raw text from the website
        String rawText = doc.text();
        if (rawText.length() > 1000) {
            rawText = rawText.substring(0, 1000);
        }

        // Use OpenAI API (ChatGPT) to generate a concise description
        String description = generateDescription(rawText);
        company.setDescription(description);

        // Attempt to find the logo URL
        String logoUrl = findLogoUrl(doc, website);
        company.setLogoUrl(logoUrl);

        return company;
    }

    private String generateDescription(String text) {
        // Simulate ChatGPT API call (pseudo-code)
        // In practice, you'd use OpenAI's API client libraries
        String prompt = "Summarize the following text in one paragraph:\n\n" + text;
        String description = ""; // Replace with actual API call

        // For demonstration purposes, we'll just return the first 200 characters
        if (text.length() > 200) {
            description = text.substring(0, 200) + "...";
        } else {
            description = text;
        }

        return description;
    }

    private String findLogoUrl(Document doc, String website) {
        // Try to find a link tag with rel 'icon' or 'shortcut icon'
        Element logoElement = doc.selectFirst("link[rel~=(?i)^(icon|shortcut icon)$]");
        if (logoElement != null) {
            String logoUrl = logoElement.attr("href");
            if (!logoUrl.startsWith("http")) {
                logoUrl = "https://" + website + "/" + logoUrl;
            }
            return logoUrl;
        }
        return null;
    }
}
