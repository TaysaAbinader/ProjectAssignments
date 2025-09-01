package OrientationChapter_1_2;

import java.time.Instant;
import java.util.PriorityQueue;

public class EventList {
    private PriorityQueue<Event> eventQueue = new PriorityQueue<>();

    public EventList () {}

    public void addEvent (Event event) {
        if (eventQueue.contains(event)) {
            System.err.println("Error: event already in the queue.");
        }
        eventQueue.add(event);
    }

    public Event pollEvent () {
        if (eventQueue.isEmpty()) {
            System.err.println("Error: event queue is empty.");
        }
        return eventQueue.poll();
    }

    public boolean isEmpty () {
        return eventQueue.isEmpty();
    }

    public static void main(String[] args) {
        EventList events = new EventList();

        events.addEvent(new Event(Instant.ofEpochSecond(1L)));
        events.addEvent(new Event(Instant.ofEpochSecond(2L)));
        events.addEvent(new Event(Instant.ofEpochSecond(3L)));
        events.addEvent(new Event(Instant.ofEpochSecond(4L)));

        while (!events.isEmpty()) {
            Event event = events.pollEvent();
            System.out.println(event);
        }

    }
}
