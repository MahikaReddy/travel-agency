package test.java.activities;
import main.java.activities.Activity;
import main.java.activities.Destination;
import main.java.passengers.StandardPassenger;
import main.java.passengers.PremiumPassenger;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActivityTest {

    @Test
    public void testSignUpForActivity() {
        // Creating a sample destination and activity.
        Destination destination = new Destination("TestDestination", null);
        Activity activity = new Activity("TestActivity", "Description", 20.0, 2, destination);

        // Creating sample passengers.
        StandardPassenger passenger1 = new StandardPassenger("Passenger1", 100.0);
        PremiumPassenger passenger2 = new PremiumPassenger("Passenger2");

        // Signing up passengers for the activity.
        assertTrue(activity.signUpForActivity(List.of(passenger1)));
        assertTrue(activity.signUpForActivity(List.of(passenger2)));

        // Attempting to sign up more passengers than the capacity allows.
        assertFalse(activity.signUpForActivity(List.of(new StandardPassenger("Passenger3", 50.0))));

        // Verifying the number of signed-up passengers.
        assertEquals(2, activity.getSignedUpPassengers().size());
    }

    @Test
    public void testGetAvailableSpaces() {
        // Creating a sample destination and activity.
        Destination destination = new Destination("TestDestination", null);
        Activity activity = new Activity("TestActivity", "Description", 20.0, 3, destination);

        // Creating sample passengers.
        StandardPassenger passenger1 = new StandardPassenger("Passenger1", 100.0);
        PremiumPassenger passenger2 = new PremiumPassenger("Passenger2");

        // Signing up passengers for the activity.
        assertTrue(activity.signUpForActivity(List.of(passenger1)));
        assertTrue(activity.signUpForActivity(List.of(passenger2)));

        // Verifying the number of available spaces.
        assertEquals(1, activity.getAvailableSpaces());
    }

    @Test
    public void testPrintDetails() {
        // Creating a sample destination and activity.
        Destination destination = new Destination("TestDestination", null);
        Activity activity = new Activity("TestActivity", "Description", 20.0, 2, destination);

        // Creating sample passengers.
        StandardPassenger passenger1 = new StandardPassenger("Passenger1", 100.0);
        PremiumPassenger passenger2 = new PremiumPassenger("Passenger2");

        // Signing up passengers for the activity.
        activity.signUpForActivity(List.of(passenger1, passenger2));

        // Redirecting System.out to capture the printed details.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Calling the method to print details.
        activity.printDetails();

        // Resetting System.out.
        System.setOut(System.out);

        // Verifying the printed details.
        // Verifying the printed details.
String expectedOutput = "Activity: TestActivity\n" +
"Description: Description\n" +
"Cost: 20.0\n" +
"Capacity: 2\n" +
"Destination: TestDestination\n" +
"Signed-Up Passengers:\n" +
"- Passenger1\n" +
"- Passenger2";

// Replace newline characters and compare
assertEquals(expectedOutput.replaceAll("\\n|\\r", ""), outputStream.toString().replaceAll("\\n|\\r", ""));

    }
}
