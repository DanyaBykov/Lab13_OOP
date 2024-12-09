package ucu.edu.ua.Task2;

public class Main {
    public static void main(String[] args) {
        Database db = new UkrDatabaseAdapter(new БазаДаних());
        Authorization auth = new UkrAuthorizationAdapter(new Авторизація());
        if (auth.authorize(db)) {
            ReportBuilder br = new ReportBuilder(db);
            br.buildReport();
        }
    }
}
