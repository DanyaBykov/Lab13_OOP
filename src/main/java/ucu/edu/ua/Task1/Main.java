package ucu.edu.ua.Task1;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        long currentTime = Instant.now().getEpochSecond();

        TwitterUser twitterUser = new TwitterUser("twitteruser@example.com", "Ukraine", currentTime);
        User twitterUserAdapter = new TwitterUserAdapter(twitterUser);

        FacebookUser facebookUser = new FacebookUser("facebookuser@example.com", "Ukraine", currentTime - 7200);
        User facebookUserAdapter = new FacebookUserAdapter(facebookUser);

        MessageSender messageSender = new MessageSender();

        System.out.println("Attempting to send message to Twitter user:");
        System.out.println(messageSender.send("Hello Twitter user!", twitterUserAdapter, "Ukraine"));

        System.out.println("\nAttempting to send message to Facebook user:");
        System.out.println(messageSender.send("Hello Facebook user!", facebookUserAdapter, "Ukraine"));
    }
}
