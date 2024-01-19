package main.java.passengers; // Adjust the package declaration based on your actual directory structure

/**
 * Represents a premium passenger, a type of passenger without a balance.
 */
public class PremiumPassenger extends Passenger {
    public PremiumPassenger(String name) {
        super(name);
    }

    // Clean Code: Redundant getter and setter removed.

    // Clean Code: Method to print details of a premium passenger.
    public void printDetails() {
        System.out.println("Premium Passenger Details:");
        System.out.println("Name: " + getName());
        System.out.println("Passenger Number: " + getPassengerNumber());
    }
}
