package main.java.passengers; // Adjust the package declaration based on your actual directory structure

/**
 * Represents a standard passenger, a type of passenger with a balance.
 */
public class StandardPassenger extends Passenger {
    // Clean Code: Redundant field removed.

    public StandardPassenger(String name, double balance) {
        super(name);
        setBalance(balance);
    }

    // Clean Code: Redundant getter and setter removed.

    // Clean Code: Method to print details of a standard passenger.
    public void printDetails() {
        System.out.println("Standard Passenger Details:");
        System.out.println("Name: " + getName());
        System.out.println("Passenger Number: " + getPassengerNumber());
        System.out.println("Balance: " + getBalance());
    }

    // Clean Code: Setter method for the balance.
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }
}
