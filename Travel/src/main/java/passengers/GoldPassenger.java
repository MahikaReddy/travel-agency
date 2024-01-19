package main.java.passengers; // Adjust the package declaration based on your actual directory structure

/**
 * Represents a gold passenger, a type of passenger with a balance.
 */
public class GoldPassenger extends Passenger {
    // Clean Code: Redundant field removed.

    public GoldPassenger(String name, double balance) {
        super(name);
        setBalance(balance);
    }

    // Clean Code: Redundant getter and setter removed.

    // Clean Code: Method to print details of a gold passenger.
    public void printDetails() {
        System.out.println("Gold Passenger Details:");
        System.out.println("Name: " + getName());
        System.out.println("Passenger Number: " + getPassengerNumber());
        System.out.println("Balance: " + getBalance());
    }
}
