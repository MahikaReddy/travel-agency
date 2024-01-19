package test.java.activities;

import main.java.activities.Activity;
import main.java.activities.ItineraryItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItineraryItemTest {

    @Test
    public void testGettersAndSetters() {
        // Creating a sample activity.
        Activity activity = new Activity("TestActivity", "TestDescription", 25.0, 2, null);

        // Creating an itinerary item with the activity.
        ItineraryItem itineraryItem = new ItineraryItem(activity);

        // Verifying the activity using the getter.
        assertEquals(activity, itineraryItem.getActivity());

        // Creating a new activity.
        Activity newActivity = new Activity("NewActivity", "NewDescription", 30.0, 3, null);

        // Updating the itinerary item with the new activity.
        itineraryItem.setActivity(newActivity);

        // Verifying the updated activity using the getter.
        assertEquals(newActivity, itineraryItem.getActivity());
    }
}
