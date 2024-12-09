package ucu.edu.ua.Task2;

public class UkrDatabaseAdapter implements Database{
    private final БазаДаних db;

    public UkrDatabaseAdapter(БазаДаних db) {
        this.db = db;
    }

    @Override
    public String getUserData() {
        return db.отриматиДаніКористувача();
    }

    @Override
    public String getStaticData() {
        return db.отриматиСтатистичніДані();
    }

    public БазаДаних getUkrainianDatabase() {
        return db;
    }
}
