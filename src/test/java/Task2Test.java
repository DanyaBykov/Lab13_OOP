import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import ucu.edu.ua.Task2.Authorization;
import ucu.edu.ua.Task2.Database;
import ucu.edu.ua.Task2.ReportBuilder;
import ucu.edu.ua.Task2.UkrAuthorizationAdapter;
import ucu.edu.ua.Task2.UkrDatabaseAdapter;
import ucu.edu.ua.Task2.Авторизація;
import ucu.edu.ua.Task2.БазаДаних;

public class Task2Test {

    @Test
    public void testUkrDatabaseAdapter() {
        БазаДаних ukrDb = new БазаДаних();
        Database dbAdapter = new UkrDatabaseAdapter(ukrDb);

        String userData = dbAdapter.getUserData();
        String staticData = dbAdapter.getStaticData();

        assertEquals("hello", userData);
        assertEquals("hello2", staticData);
    }

    @Test
    public void testUkrAuthorizationAdapter() {
        Авторизація ukrAuth = new Авторизація();
        Authorization authAdapter = new UkrAuthorizationAdapter(ukrAuth);

        БазаДаних ukrDb = new БазаДаних();
        Database dbAdapter = new UkrDatabaseAdapter(ukrDb);

        boolean isAuthorized = authAdapter.authorize(dbAdapter);

        assertTrue(isAuthorized);
    }

    @Test
    public void testReportBuilder() {
        БазаДаних ukrDb = new БазаДаних();
        Database dbAdapter = new UkrDatabaseAdapter(ukrDb);

        ReportBuilder reportBuilder = new ReportBuilder(dbAdapter);

        // Capture the output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        reportBuilder.buildReport();

        String expectedOutput = """
                                Building report...
                                User data: hello
                                Static data: hello2
                                """;

        assertEquals(expectedOutput, outContent.toString());

        // Reset the standard output
        System.setOut(System.out);
    }

    @Test
    public void testAuthorizationAndReportGeneration() {
        БазаДаних ukrDb = new БазаДаних();
        Database dbAdapter = new UkrDatabaseAdapter(ukrDb);

        Авторизація ukrAuth = new Авторизація();
        Authorization authAdapter = new UkrAuthorizationAdapter(ukrAuth);

        if (authAdapter.authorize(dbAdapter)) {
            ReportBuilder reportBuilder = new ReportBuilder(dbAdapter);

            // Capture the output
            java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outContent));

            reportBuilder.buildReport();

            String expectedOutput = """
                                    Building report...
                                    User data: hello
                                    Static data: hello2
                                    """;

            assertEquals(expectedOutput, outContent.toString());

            // Reset the standard output
            System.setOut(System.out);
        } else {
            fail("Authorization failed");
        }
    }
}
