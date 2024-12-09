import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ucu.edu.ua.Task1.FacebookUser;
import ucu.edu.ua.Task1.FacebookUserAdapter;
import ucu.edu.ua.Task1.MessageSender;
import ucu.edu.ua.Task1.TwitterUser;
import ucu.edu.ua.Task1.TwitterUserAdapter;
import ucu.edu.ua.Task1.User;

public class Task1Test {

    @Test
    public void testTwitterUserAdapter() {
        long currentTime = Instant.now().getEpochSecond();
        TwitterUser twitterUser = new TwitterUser("twitter@example.com", "USA", currentTime);
        User userAdapter = new TwitterUserAdapter(twitterUser);

        assertEquals("twitter@example.com", userAdapter.getEmail());
        assertEquals("USA", userAdapter.getCountry());
        assertEquals(currentTime, userAdapter.getLastActiveTime());
    }

    @Test
    public void testFacebookUserAdapter() {
        long currentTime = Instant.now().getEpochSecond();
        FacebookUser facebookUser = new FacebookUser("facebook@example.com", "Canada", currentTime);
        User userAdapter = new FacebookUserAdapter(facebookUser);

        assertEquals("facebook@example.com", userAdapter.getEmail());
        assertEquals("Canada", userAdapter.getCountry());
        assertEquals(currentTime, userAdapter.getLastActiveTime());
    }

    @Test
    public void testMessageSenderWithActiveTwitterUser() {
        long currentTime = Instant.now().getEpochSecond();
        TwitterUser twitterUser = new TwitterUser("active_twitter@example.com", "Ukraine", currentTime);
        User userAdapter = new TwitterUserAdapter(twitterUser);
        MessageSender sender = new MessageSender();

        assertEquals("Sending message to " + userAdapter.getEmail() + ": Hello Twitter User!", sender.send("Hello Twitter User!", userAdapter, "Ukraine"));

    }

    @Test
    public void testMessageSenderWithInactiveFacebookUser() {
        long currentTime = Instant.now().getEpochSecond();
        long twoHoursAgo = currentTime - 7200; // 2 hours ago
        FacebookUser facebookUser = new FacebookUser("inactive_facebook@example.com", "Ukraine", twoHoursAgo);
        User userAdapter = new FacebookUserAdapter(facebookUser);
        MessageSender sender = new MessageSender();

        assertEquals("User is not from the specified country or not active in the last hour.", sender.send("Hello Facebook User!", userAdapter, "Ukraine"));
    }

    @Test
    public void testMessageSenderWithDifferentCountry() {
        long currentTime = Instant.now().getEpochSecond();
        TwitterUser twitterUser = new TwitterUser("twitter@example.com", "USA", currentTime);
        User userAdapter = new TwitterUserAdapter(twitterUser);
        MessageSender sender = new MessageSender();

        assertEquals("User is not from the specified country or not active in the last hour.", sender.send("Hello!", userAdapter, "Ukraine"));
    }
}