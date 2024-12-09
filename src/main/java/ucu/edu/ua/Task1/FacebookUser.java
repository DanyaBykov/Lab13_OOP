package ucu.edu.ua.Task1;

public class FacebookUser {
    private final String email;
    private final String userCountry;
    private final long userActiveTime;

    public FacebookUser(String email, String userCountry, long userActiveTime) {
        this.email = email;
        this.userCountry = userCountry;
        this.userActiveTime = userActiveTime;
    }

    public String getEmail() {
        return email;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public long getUserActiveTime() {
        return userActiveTime;
    }
}
