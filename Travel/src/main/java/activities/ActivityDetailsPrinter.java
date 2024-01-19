package main.java.activities; // Adjust the package declaration based on your actual directory structure

import java.util.List;
import main.java.passengers.Passenger; // Import the Passenger class

/**
 * Represents a utility class to print details of an activity.
 */
public class ActivityDetailsPrinter {
    // Clean Code: Method to print details of an activity.
    public static void printDetails(Activity activity) {
        System.out.println("Activity Details:");
        System.out.println("Name: " + activity.getName());
        System.out.println("Description: " + activity.getDescription());
        System.out.println("Cost: " + activity.getCost());
        System.out.println("Capacity: " + activity.getCapacity());
        System.out.println("Destination: " + (activity.getDestination() != null ? activity.getDestination().getName() : "Not specified"));

        List<Passenger> signedUpPassengers = activity.getSignedUpPassengers();
        if (signedUpPassengers != null && !signedUpPassengers.isEmpty()) {
            System.out.println("Signed-Up Passengers:");
            for (Passenger passenger : signedUpPassengers) {
                System.out.println("- " + passenger.getName());
            }
        } else {
            System.out.println("No passengers signed up yet.");
        }
    }
}
