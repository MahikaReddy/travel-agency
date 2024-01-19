package main.java.activities; // Adjust the package declaration based on your actual directory structure

import java.util.ArrayList;
import java.util.List;
import main.java.passengers.Passenger; // Import the Passenger class

/**
 * Represents an activity with a name, description, cost, capacity, signed-up passengers, and destination.
 */
public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private List<Passenger> signedUpPassengers;
    private Destination destination;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.signedUpPassengers = new ArrayList<>();
        this.destination = destination;
    }
    // Clean Code: Method to print details of an activity.
    public void printDetails() {
        System.out.println("Activity: " + name);
        System.out.println("Description: " + description);
        System.out.println("Cost: " + cost);
        System.out.println("Capacity: " + capacity);
        System.out.println("Destination: " + (destination != null ? destination.getName() : "Not specified"));

        if (signedUpPassengers != null && !signedUpPassengers.isEmpty()) {
            System.out.println("Signed-Up Passengers:");
            for (Passenger passenger : signedUpPassengers) {
                System.out.println("- " + passenger.getName());
            }
        } else {
            System.out.println("No passengers signed up yet.");
        }
    }

    // Clean Code: Method to set signed-up passengers.
    private void setSignedUpPassengers(List<Passenger> signedUpPassengers) {
        if (signedUpPassengers == null) {
            throw new IllegalArgumentException("Invalid input: Signed-up passengers list is null.");
        }
        this.signedUpPassengers = signedUpPassengers;
    }

    // Clean Code: Method to sign up passengers for an activity.
    public boolean signUpForActivity(List<Passenger> passengers) {
        if (passengers == null || passengers.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: Passenger list is null or empty.");
        }

        if (signedUpPassengers.size() + passengers.size() > capacity) {
            System.out.println("Activity " + name + " is at full capacity. Cannot sign up more passengers.");
            return false;
        }

        signedUpPassengers.addAll(passengers);

        setSignedUpPassengers(signedUpPassengers);
        return true;
    }

    // Clean Code: Method to get available spaces for an activity.
    public int getAvailableSpaces() {
        return capacity - signedUpPassengers.size();
    }

    // Clean Code: Getter method for the name.
    public String getName() {
        return name;
    }

    // Clean Code: Getter method for the description.
    public String getDescription() {
        return description;
    }

    // Clean Code: Getter method for the cost.
    public double getCost() {
        return cost;
    }

    // Clean Code: Getter method for the capacity.
    public int getCapacity() {
        return capacity;
    }

    // Clean Code: Getter method for signed-up passengers.
    public List<Passenger> getSignedUpPassengers() {
        return signedUpPassengers;
    }

    // Clean Code: Getter method for the destination.
    public Destination getDestination() {
        return destination;
    }

    // Clean Code: Setter method for the name.
    public void setName(String name) {
        this.name = name;
    }

    // Clean Code: Setter method for the description.
    public void setDescription(String description) {
        this.description = description;
    }

    // Clean Code: Setter method for the cost.
    public void setCost(double cost) {
        this.cost = cost;
    }

    // Clean Code: Setter method for the capacity.
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Clean Code: Setter method for the destination.
    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
