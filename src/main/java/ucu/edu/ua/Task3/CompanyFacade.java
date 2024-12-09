package ucu.edu.ua.Task3;

import java.io.IOException;

public class CompanyFacade {
    private PDLReader pdlReader;
    private WebScraperHandler webScraperHandler;
    private BrandfetchHandler brandfetchHandler;

    public CompanyFacade() {
        pdlReader = new PDLReader();
        webScraperHandler = new WebScraperHandler();
        brandfetchHandler = new BrandfetchHandler();
    }

    public Company getCompanyData(String domain) {
        Company company = new Company();

        // Retrieve data from PDL
        try {
            Company pdlData = pdlReader.getCompanyData(domain);
            mergeCompanyData(company, pdlData);
        } catch (IOException e) {
            System.err.println("PDLHandler: " + e.getMessage());
        }

        // Retrieve data from Brandfetch
        try {
            Company bfData = brandfetchHandler.getCompanyData(domain);
            mergeCompanyData(company, bfData);
        } catch (IOException e) {
            System.err.println("BrandfetchHandler: " + e.getMessage());
        }

        // Retrieve data from Web Scraper
        try {
            Company wsData = webScraperHandler.getCompanyData(domain);
            mergeCompanyData(company, wsData);
        } catch (IOException e) {
            System.err.println("WebScraperHandler: " + e.getMessage());
        }

        return company;
    }

    private void mergeCompanyData(Company mainCompany, Company newData) {
        if (mainCompany.getName() == null && newData.getName() != null) {
            mainCompany.setName(newData.getName());
        }
        if (mainCompany.getDescription() == null && newData.getDescription() != null) {
            mainCompany.setDescription(newData.getDescription());
        }
        if (mainCompany.getLogoUrl() == null && newData.getLogoUrl() != null) {
            mainCompany.setLogoUrl(newData.getLogoUrl());
        }
    }
}
