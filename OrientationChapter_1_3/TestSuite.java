package OrientationChapter_1_3;

import java.time.Instant;

import OrientationChapter_1_1.Customer;
import OrientationChapter_1_1.ServicePoint;
import OrientationChapter_1_2.Event;
import OrientationChapter_1_2.EventList;

public class TestSuite {
    public static void main (String[] args) {
        ArrivalProcess process = new ArrivalProcess();
        EventList events = new EventList();
        Clock clock = Clock.getInstance();

        // Create 10 arrival events and add them to the priority queue.
        for (int i = 0; i < 10; i++) {
            process.generateArrivalEventToEventList(events);
        }

        ServicePoint servicePoint = new ServicePoint();

        // Update the clock to the last event.
        while (!events.isEmpty()) {
            Event event = events.pollEvent();
            Customer customer = new Customer();

            // Event time in milliseconds since Epoch.
            long eventTimeInMilliseconds = event.getInstant().toEpochMilli();

            // Convert millisecond to nanosecond.
            customer.setStartTime(eventTimeInMilliseconds * 1_000_000);
            servicePoint.addToQueue(customer);
            
            // Move clock forward by 5 seconds.
            clock.setTime(clock.getTime() + 5L);
        }

        servicePoint.serve();

        System.out.println("Clock time for the last event created: " + clock.getTime() + " seconds.");
    }
}
