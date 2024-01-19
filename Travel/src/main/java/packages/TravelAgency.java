package main.java.packages;

import java.util.ArrayList;
import java.util.List;

import main.java.activities.Activity;
import main.java.activities.ItineraryItem;
import main.java.activities.ActivityDetailsPrinter;
import main.java.passengers.StandardPassenger;
import main.java.passengers.GoldPassenger;
import main.java.passengers.PremiumPassenger;
import main.java.activities.Destination;

/**
 * Represents a travel agency that manages travel packages.
 */
public class TravelAgency {
    private List<TravelPackage> packages;

    // Clean Code: Constructor to initialize the list of packages.
    public TravelAgency() {
        this.packages = new ArrayList<>();
    }

    // Clean Code: Method to add a travel package to the agency.
    public void addPackage(TravelPackage travelPackage) {
        packages.add(travelPackage);
    }

    // Clean Code: Method to remove a travel package from the agency.
    public void removePackage(TravelPackage travelPackage) {
        packages.remove(travelPackage);
    }

    // Clean Code: Method to print available activities in all packages.
    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (TravelPackage travelPackage : packages) {
            for (ItineraryItem itineraryItem : travelPackage.getItinerary()) {
                Activity activity = itineraryItem.getActivity();
                int availableSpaces = activity.getAvailableSpaces();
                if (availableSpaces > 0) {
                    System.out.println("Activity: " + activity.getName() +
                            ", Destination: " + activity.getDestination().getName() +
                            ", Available Spaces: " + availableSpaces);
                }
            }
        }
    }

    // Clean Code: Getter method for the list of packages.
    public List<TravelPackage> getPackages() {
        return packages;
    }

    // Clean Code: Setter method for the list of packages.
    public void setPackages(List<TravelPackage> packages) {
        this.packages = packages;
    }

    // Clean Code: Main method for testing the functionality.
    public static void main(String[] args) {
        // Creating a sample destination and travel package.
        Destination paris = new Destination("Paris", List.of(
                new Activity("Eiffel Tower Visit", "Visit the iconic Eiffel Tower", 50.0, 100, null),
                new Activity("Louvre Museum Visit", "Explore the Louvre Museum", 30.0, 150, null)
        ));

        TravelPackage package1 = new TravelPackage("Package 1", paris, 2000.0, 20);

        // Creating sample passengers and signing them up for activities.
        StandardPassenger standardPassenger = new StandardPassenger("John Doe", 1000.0);
        GoldPassenger goldPassenger = new GoldPassenger("Jane Doe", 1500.0);
        PremiumPassenger premiumPassenger = new PremiumPassenger("Alice Smith");

        package1.addPassenger(standardPassenger);
        package1.addPassenger(goldPassenger);
        package1.addPassenger(premiumPassenger);

        Activity eiffelTowerVisit = new Activity("Eiffel Tower Visit", "Visit the iconic Eiffel Tower", 50.0, 100, paris);
        ItineraryItem itineraryItem = new ItineraryItem(eiffelTowerVisit);

        eiffelTowerVisit.signUpForActivity(List.of(standardPassenger));
        standardPassenger.setBalance(standardPassenger.getBalance() - eiffelTowerVisit.getCost());

        eiffelTowerVisit.signUpForActivity(List.of(goldPassenger));
        goldPassenger.setBalance(goldPassenger.getBalance() - (eiffelTowerVisit.getCost() * 0.9));

        eiffelTowerVisit.signUpForActivity(List.of(premiumPassenger));

        package1.addItineraryItem(itineraryItem);

        // Creating a travel agency and adding the package to it.
        TravelAgency travelAgency = new TravelAgency();
        travelAgency.addPackage(package1);

        // Printing details of the package, passenger list, activity, and available activities.
        package1.printItinerary();
        package1.printPassengerList();
        ActivityDetailsPrinter.printDetails(eiffelTowerVisit);
        travelAgency.printAvailableActivities();
    }
}
