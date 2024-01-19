package test.java.activities;
import main.java.activities.Activity;
import main.java.activities.Destination;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DestinationTest {

    @Test
    public void testPrintDetails() {
        // Creating a sample destination with activities.
        Destination destination = new Destination("TestDestination", List.of(
                new Activity("Activity1", "Description1", 20.0, 2, null),
                new Activity("Activity2", "Description2", 30.0, 3, null)
        ));

        // Redirecting System.out to capture the printed details.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Calling the method to print details.
        destination.printDetails();

        // Resetting System.out.
        System.setOut(System.out);

        // Verifying the printed details.
        // Verifying the printed details.
String expectedOutput = "Destination: TestDestination\n" +
"Activity: Activity1\n" +
"Description: Description1\n" +
"Cost: 20.0\n" +
"Capacity: 2\n" +
"Destination: Not specified\n" +
"Signed-Up Passengers:\n" +
"No passengers signed up yet.\n" +
"Activity: Activity2\n" +
"Description: Description2\n" +
"Cost: 30.0\n" +
"Capacity: 3\n" +
"Destination: Not specified\n" +
"Signed-Up Passengers:\n" +
"No passengers signed up yet.";

// Replace newline characters and compare
assertEquals(expectedOutput.replaceAll("\\n|\\r", ""), outputStream.toString().replaceAll("\\n|\\r", ""));

    }

    @Test
    public void testGettersAndSetters() {
        // Creating a sample destination with activities.
        Destination destination = new Destination("TestDestination", List.of(
                new Activity("Activity1", "Description1", 20.0, 2, null),
                new Activity("Activity2", "Description2", 30.0, 3, null)
        ));

        // Modifying the destination's name and activities.
        destination.setName("UpdatedDestination");
        destination.setActivities(List.of(new Activity("NewActivity", "NewDescription", 25.0, 1, null)));

        // Verifying the changes using getters.
        assertEquals("UpdatedDestination", destination.getName());
        assertEquals(1, destination.getActivities().size());
    }
}
