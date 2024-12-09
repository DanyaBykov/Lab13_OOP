package ucu.edu.ua.Task1;

public class TwitterUser {
    private final String userMail;
    private final String country;
    private final long lastActiveTime;

    public TwitterUser(String userMail, String country, long lastActiveTime) {
        this.userMail = userMail;
        this.country = country;
        this.lastActiveTime = lastActiveTime;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getCountry() {
        return country;
    }

    public long getLastActiveTime() {
        return lastActiveTime;
    }
}
