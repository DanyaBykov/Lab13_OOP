import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import ucu.edu.ua.Task3.BrandfetchHandler;
import ucu.edu.ua.Task3.Company;
import ucu.edu.ua.Task3.CompanyFacade;
import ucu.edu.ua.Task3.PDLReader;
import ucu.edu.ua.Task3.WebScraperHandler;

public class Task3Test {

    @Test
    public void testPDLReader() {
        PDLReader pdlReader = new PDLReader();

        try {
            Company company = pdlReader.getCompanyData("ucu.edu.ua");
            assertNotNull(company, "Company should not be null");
            assertNotNull(company.getName(), "Company name should not be null");
            assertNotNull(company.getDescription(), "Company description should not be null");
            assertNotNull(company.getLogoUrl(), "Company logo URL should not be null");

            System.out.println("PDLReader Output:");
            System.out.println(company);
        } catch (Exception e) {
            System.out.println("Exception occurred while testing PDLReader: " + e.getMessage());
        }
    }

    @Test
    public void testBrandfetchHandler() {
        BrandfetchHandler brandfetchHandler = new BrandfetchHandler();

        try {
            Company company = brandfetchHandler.getCompanyData("ucu.edu.ua");
            assertNotNull(company, "Company should not be null");
            assertNotNull(company.getName(), "Company name should not be null");
            // Description may be null
            // Logo URL may be null

            System.out.println("BrandfetchHandler Output:");
            System.out.println(company);
        } catch (Exception e) {
            System.out.println("Exception occurred while testing BrandfetchHandler: " + e.getMessage());
        }
    }

    @Test
    public void testWebScraperHandler() {
        WebScraperHandler webScraperHandler = new WebScraperHandler();

        try {
            Company company = webScraperHandler.getCompanyData("ucu.edu.ua");
            assertNotNull(company, "Company should not be null");
            assertNotNull(company.getName(), "Company name should not be null");
            assertNotNull(company.getDescription(), "Company description should not be null");
            // Logo URL may be null

            System.out.println("WebScraperHandler Output:");
            System.out.println(company);
        } catch (Exception e) {
            System.out.println("Exception occurred while testing WebScraperHandler: " + e.getMessage());
        }
    }

    @Test
    public void testCompanyFacade() {
        CompanyFacade companyFacade = new CompanyFacade();

        Company company = companyFacade.getCompanyData("ucu.edu.ua");

        assertNotNull(company, "Company should not be null");
        assertNotNull(company.getName(), "Company name should not be null");
        assertNotNull(company.getDescription(), "Company description should not be null");
        assertNotNull(company.getLogoUrl(), "Company logo URL should not be null");

        System.out.println("CompanyFacade Output:");
        System.out.println(company);
    }
}