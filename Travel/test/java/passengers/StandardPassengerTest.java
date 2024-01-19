package test.java.passengers;
import main.java.passengers.StandardPassenger;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StandardPassengerTest {

    @Test
    public void testConstructorWithNameAndBalance() {
        // Creating a sample standard passenger with a name and balance.
        StandardPassenger standardPassenger = new StandardPassenger("John Doe", 1000.0);

        // Verifying that the name is set correctly.
        assertEquals("John Doe", standardPassenger.getName());

        // Verifying that the balance is set correctly.
        assertEquals(1000.0, standardPassenger.getBalance(), 0.01);

        // Verifying that the passenger number is generated.
        assertNotNull(standardPassenger.getPassengerNumber());
    }

    @Test
    public void testSetBalance() {
        // Creating a sample standard passenger.
        StandardPassenger standardPassenger = new StandardPassenger("Alice", 0);

        // Setting and verifying the balance.
        standardPassenger.setBalance(1500.0);
        assertEquals(1500.0, standardPassenger.getBalance(), 0.01);

        // Verifying that an exception is thrown for a negative balance.
        assertThrows(IllegalArgumentException.class, () -> standardPassenger.setBalance(-500.0));
    }

    @Test
    
public void testPrintDetails() {
    // Creating a sample standard passenger.
    StandardPassenger standardPassenger = new StandardPassenger("Bob", 1200.0);

    // Redirecting System.out for testing print statements.
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Printing and capturing the output.
    standardPassenger.printDetails();
    String printedOutput = outputStream.toString().trim();

    // Verifying the printed details.
    assertTrue(printedOutput.startsWith("Standard Passenger Details:"));
    assertTrue(printedOutput.contains("Name: Bob"));
    assertTrue(printedOutput.contains("Passenger Number:"));
    assertTrue(printedOutput.contains("Balance: 1200.0"));

    // Resetting System.out.
    System.setOut(System.out);
}
}
