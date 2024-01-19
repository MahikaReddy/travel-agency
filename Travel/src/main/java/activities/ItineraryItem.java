package main.java.activities; // Adjust the package declaration based on your actual directory structure

/**
 * Represents an item in an itinerary with an associated activity.
 */
public class ItineraryItem {
    private Activity activity;

    public ItineraryItem(Activity activity) {
        this.activity = activity;
    }

    // Clean Code: Getter method for the activity.
    public Activity getActivity() {
        return activity;
    }

    // Clean Code: Setter method for the activity.
    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
