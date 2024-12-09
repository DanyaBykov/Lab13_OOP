package ucu.edu.ua.Task1;

import java.time.Instant;

public class MessageSender {
    public String send(String text, User user, String country) {
        long currentTime = Instant.now().getEpochSecond();
        long oneHourAgo = currentTime - 3600; // 3600 seconds = 1 hour

        if (user.getCountry().equalsIgnoreCase(country) && user.getLastActiveTime() >= oneHourAgo) {
            System.out.println("Sending message to " + user.getEmail() + ": " + text);
            return "Sending message to " + user.getEmail() + ": " + text;
        } else {
            System.out.println("User is not from the specified country or not active in the last hour.");
            return "User is not from the specified country or not active in the last hour.";
        }
    }
}
