package test.java.activities;

import main.java.activities.Activity;
import main.java.activities.ActivityDetailsPrinter;
import main.java.passengers.GoldPassenger;
import main.java.passengers.StandardPassenger;
import main.java.activities.Destination;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityDetailsPrinterTest {

    @Test
    public void testPrintDetails() {
        // Creating a sample destination and activity.
        Destination destination = new Destination("TestDestination", null);
        Activity activity = new Activity("TestActivity", "Description", 20.0, 50, destination);

        // Creating sample passengers and signing them up for the activity.
        StandardPassenger passenger1 = new StandardPassenger("Passenger1", 100.0);
        GoldPassenger passenger2 = new GoldPassenger("Passenger2", 150.0);

        activity.signUpForActivity(List.of(passenger1, passenger2));

        // Redirecting System.out to capture the printed details.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Calling the method to print details.
        ActivityDetailsPrinter.printDetails(activity);

        // Resetting System.out.
        System.setOut(System.out);

        // Verifying the printed details.
        String expectedOutput = "Activity Details:\n" +
                "Name: TestActivity\n" +
                "Description: Description\n" +
                "Cost: 20.0\n" +
                "Capacity: 50\n" +
                "Destination: TestDestination\n" +
                "Signed-Up Passengers:\n" +
                "- Passenger1\n" +
                "- Passenger2";

        // Replace newline characters and compare
        assertEquals(expectedOutput.replaceAll("\\n|\\r", ""), outputStream.toString().replaceAll("\\n|\\r", ""));
    }
}
