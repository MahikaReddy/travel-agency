package test.java.passengers;

import main.java.passengers.Passenger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    public void testConstructorWithName() {
        // Creating a sample passenger with a name.
        Passenger passenger = new Passenger("John Doe");

        // Verifying that the name is set correctly.
        assertEquals("John Doe", passenger.getName());

        // Verifying that the passenger number is generated.
        assertNotNull(passenger.getPassengerNumber());
    }

    @Test
    public void testConstructorWithNumber() {
        // Creating a sample passenger with a name and a specified passenger number.
        Passenger passenger = new Passenger("Jane Doe", "PN123");

        // Verifying that the name is set correctly.
        assertEquals("Jane Doe", passenger.getName());

        // Verifying that the specified passenger number is set correctly.
        assertEquals("PN123", passenger.getPassengerNumber());
    }

    @Test
    public void testSetBalance() {
        // Creating a sample passenger.
        Passenger passenger = new Passenger("Alice");

        // Setting and verifying the balance.
        passenger.setBalance(500.0);
        assertEquals(500.0, passenger.getBalance());
    }

    @Test
    public void testSetPassengerNumber() {
        // Creating a sample passenger.
        Passenger passenger = new Passenger("Bob");

        // Setting and verifying the passenger number.
        passenger.setPassengerNumber("PN456");
        assertEquals("PN456", passenger.getPassengerNumber());

        // Verifying that an exception is thrown for an invalid passenger number format.
        assertThrows(IllegalArgumentException.class, () -> passenger.setPassengerNumber("Invalid"));
    }
}
