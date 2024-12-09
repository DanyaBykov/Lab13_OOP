package ucu.edu.ua.Task3;

public class Company {
    private String name;
    private String description;
    private String logoUrl;

    public Company() {}

    public Company(String name, String description, String logoUrl) {
        this.name = name;
        this.description = description;
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "Company{" +
               "name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", logoUrl='" + logoUrl + '\'' +
               '}';
    }
}
