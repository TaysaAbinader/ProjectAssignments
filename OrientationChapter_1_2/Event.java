package OrientationChapter_1_2;

import java.time.Instant;

public class Event implements Comparable<Event> {
     private Instant timestamp;
     public enum EventType { ARRIVAL, EXIT };
     private EventType eventType;

     public Event (EventType eventType, Instant timestamp) {
        this.eventType = eventType;
        this.timestamp = timestamp;
    }

    public EventType getEventType () {
        return eventType;
    }

    public Instant getInstant () {
        return timestamp;
    }

    @Override
    public int compareTo(Event other) {
        return this.timestamp.compareTo(other.timestamp);
    }

    @Override
    public String toString() {
        return this.eventType.toString() + " - " + this.timestamp.toString();
    }

}
