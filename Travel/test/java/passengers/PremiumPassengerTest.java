package test.java.passengers;

import main.java.passengers.PremiumPassenger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PremiumPassengerTest {

    @Test
    public void testConstructorWithName() {
        // Creating a sample premium passenger with a name.
        PremiumPassenger premiumPassenger = new PremiumPassenger("John Doe");

        // Verifying that the name is set correctly.
        assertEquals("John Doe", premiumPassenger.getName());

        // Verifying that the passenger number is generated.
        assertNotNull(premiumPassenger.getPassengerNumber());
    }

    @Test
    public void testSetPassengerNumber() {
        // Creating a sample premium passenger.
        PremiumPassenger premiumPassenger = new PremiumPassenger("Alice");

        // Setting and verifying the passenger number.
        premiumPassenger.setPassengerNumber("PN789");
        assertEquals("PN789", premiumPassenger.getPassengerNumber());

        // Verifying that an exception is thrown for an invalid passenger number format.
        assertThrows(IllegalArgumentException.class, () -> {
            premiumPassenger.setPassengerNumber("Invalid");
        }, "Invalid passenger number format.");
    }
}
