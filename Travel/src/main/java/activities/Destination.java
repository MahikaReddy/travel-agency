package main.java.activities; // Adjust the package declaration based on your actual directory structure

import java.util.List;

import main.java.passengers.Passenger;

/**
 * Represents a destination with a name and a list of activities.
 */
public class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name, List<Activity> activities) {
        this.name = name;
        this.activities = activities;
    }

    // Clean Code: Method to print details of a destination.
    public void printDetails() {
        System.out.println("Destination: " + getName());
        
        for (Activity activity : activities) {
            System.out.println("Activity: " + activity.getName());
            System.out.println("Description: " + activity.getDescription());
            System.out.println("Cost: " + activity.getCost());
            System.out.println("Capacity: " + activity.getCapacity());
            System.out.println("Destination: " + (activity.getDestination() != null ? activity.getDestination().getName() : "Not specified"));
    
            List<Passenger> signedUpPassengers = activity.getSignedUpPassengers();
            System.out.println("Signed-Up Passengers:");
            
            if (!signedUpPassengers.isEmpty()) {
                for (Passenger passenger : signedUpPassengers) {
                    System.out.println("- " + passenger);
                }
            } else {
                System.out.println("No passengers signed up yet.");
            }
    
            System.out.println();  // Add a newline between activities
        }
    }
    

    // Clean Code: Getter method for the name.
    public String getName() {
        return name;
    }

    // Clean Code: Getter method for activities.
    public List<Activity> getActivities() {
        return activities;
    }

    // Clean Code: Setter method for the name.
    public void setName(String name) {
        this.name = name;
    }

    // Clean Code: Setter method for activities.
    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
