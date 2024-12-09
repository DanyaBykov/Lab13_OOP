package ucu.edu.ua.Task3;

public class Main {
    public static void main(String[] args) {
        CompanyFacade companyFacade = new CompanyFacade();

        String domain = "ucu.edu.ua";

        Company company = companyFacade.getCompanyData(domain);

        System.out.println("Company Data:");
        System.out.println("Name: " + company.getName());
        System.out.println("Description: " + company.getDescription());
        System.out.println("Logo URL: " + company.getLogoUrl());
    }
}
