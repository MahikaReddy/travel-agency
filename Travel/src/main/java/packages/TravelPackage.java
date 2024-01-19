package main.java.packages; // Adjust the package declaration based on your actual directory structure

import java.util.ArrayList;
import java.util.List;

import main.java.activities.Activity;
import main.java.activities.ItineraryItem;
import main.java.activities.Destination;
import main.java.passengers.Passenger;

/**
 * Represents a travel package with a package name, destination, price, passenger capacity, itinerary, and passengers.
 */
public class TravelPackage {
    private String packageName;
    private Destination destination;
    private double price;
    private int passengerCapacity;
    private List<ItineraryItem> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String packageName, Destination destination, double price, int passengerCapacity) {
        this.packageName = packageName;
        this.destination = destination;
        this.price = price;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    // Clean Code: Method to add an itinerary item to the package.
    public void addItineraryItem(ItineraryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Invalid input: Itinerary item is null.");
        }

        Activity activity = item.getActivity();
        if (activity == null) {
            throw new IllegalArgumentException("Invalid input: Activity in itinerary item is null.");
        }

        if (!activity.signUpForActivity(passengers)) {
            throw new IllegalArgumentException("Cannot add itinerary item. Activity is at full capacity.");
        }

        itinerary.add(item);
    }

    // Clean Code: Method to set passengers for the package.
    private void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    // Clean Code: Method to add a passenger to the package.
    public boolean addPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Invalid input: Passenger is null.");
        }

        if (passengers.size() >= passengerCapacity) {
            throw new IllegalArgumentException("Package is already at full capacity. Cannot add more passengers.");
        }

        passengers.add(passenger);

        setPassengers(passengers);
        return true;
    }

    // Clean Code: Method to print itinerary details.
    public void printItinerary() {
        System.out.println("Travel Package: " + packageName);
        destination.printDetails();
    }

    // Clean Code: Method to print the passenger list.
    public void printPassengerList() {
        System.out.println("Travel Package: " + packageName +
                ", Passenger Capacity: " + passengerCapacity +
                ", Number of Passengers Enrolled: " + passengers.size());

        for (Passenger passenger : passengers) {
            System.out.println("Passenger: " + passenger.getName() +
                    ", Passenger Number: " + passenger.getPassengerNumber());
        }
    }

    // Clean Code: Getter method for the package name.
    public String getPackageName() {
        return packageName;
    }

    // Clean Code: Getter method for the destination.
    public Destination getDestination() {
        return destination;
    }

    // Clean Code: Getter method for the price.
    public double getPrice() {
        return price;
    }

    // Clean Code: Getter method for the passenger capacity.
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    // Clean Code: Getter method for the itinerary.
    public List<ItineraryItem> getItinerary() {
        return itinerary;
    }

    // Clean Code: Getter method for the passengers.
    public List<Passenger> getPassengers() {
        return passengers;
    }

    // Clean Code: Setter method for the package name.
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    // Clean Code: Setter method for the destination.
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    // Clean Code: Setter method for the price.
    public void setPrice(double price) {
        this.price = price;
    }

    // Clean Code: Setter method for the passenger capacity.
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    // Clean Code: Setter method for the itinerary.
    public void setItinerary(List<ItineraryItem> itinerary) {
        this.itinerary = itinerary;
    }
}
