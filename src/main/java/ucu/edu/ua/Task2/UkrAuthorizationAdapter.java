package ucu.edu.ua.Task2;

public class UkrAuthorizationAdapter implements Authorization{
    private final Авторизація auth;

    public UkrAuthorizationAdapter(Авторизація auth) {
        this.auth = auth;
    }

    @Override
    public boolean authorize(Database db) {
        if (db instanceof UkrDatabaseAdapter ukrDatabaseAdapter) {
            БазаДаних ukrDb = ukrDatabaseAdapter.getUkrainianDatabase();
            return auth.авторизуватися(ukrDb);
        }
        throw new IllegalArgumentException("Invalid database type");
    }
}
