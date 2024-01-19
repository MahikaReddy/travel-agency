package test.java.passengers;

import main.java.passengers.GoldPassenger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GoldPassengerTest {

    @Test
    public void testPrintDetails() {
        // Creating a sample gold passenger.
        GoldPassenger goldPassenger = new GoldPassenger("John Doe", 1500.0);

        // Redirecting System.out for testing print output.
        String expectedOutput = "Gold Passenger Details:\n" +
                "Name: John Doe\n" +
                "Passenger Number: " + goldPassenger.getPassengerNumber() + "\n" +
                "Balance: 1500.0\n";

        // Using the assertEquals method to compare expected and actual output.
        assertEquals(normalize(expectedOutput), normalize(getPrintedDetails(goldPassenger)));
    }

    // Helper method to capture printed details.
    private String getPrintedDetails(GoldPassenger goldPassenger) {
        // Redirecting System.out for testing print output.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Calling the printDetails method.
        goldPassenger.printDetails();

        // Resetting System.out to the console.
        System.setOut(System.out);

        // Returning the captured output.
        return outputStream.toString().trim();
    }

    // Helper method to normalize line endings and trim whitespaces.
    private String normalize(String input) {
        return input.replaceAll("\\r\\n", "\n").trim();
    }
}
