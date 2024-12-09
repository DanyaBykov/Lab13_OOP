package ucu.edu.ua.Task2;

public class ReportBuilder {
    private Database db;

    public ReportBuilder(Database db) {
        this.db = db;
    }
    
    public void buildReport() {
        System.out.println("Building report...");
        System.out.println("User data: " + db.getUserData());
        System.out.println("Static data: " + db.getStaticData());
    }
}
