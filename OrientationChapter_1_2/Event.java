package OrientationChapter_1_2;

import java.time.Instant;

public class Event implements Comparable<Event> {
     private Instant timestamp;

     public Event (Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Event other) {
        return this.timestamp.compareTo(other.timestamp);
    }

    @Override
    public String toString() {
        return this.timestamp.toString();
    }
}
