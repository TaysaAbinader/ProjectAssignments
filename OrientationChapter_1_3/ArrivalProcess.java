package OrientationChapter_1_3;

import java.time.Instant;

import OrientationChapter_1_2.Event;
import OrientationChapter_1_2.Event.EventType;
import OrientationChapter_1_2.EventList;
import OrientationChapter_1_3.eduni.distributions.Normal;

public class ArrivalProcess {
    private EventType eventType;
    // Normal distribution becomes a singleton.
    private static Normal normalDistribution = new Normal(500.0, 30000.0, 12345L);

    public ArrivalProcess () {
        this.eventType = EventType.ARRIVAL;
    }

    public EventType getEventType () {
        return this.eventType;
    }

    public Normal getNormalDistribution () {
        return normalDistribution;
    }

    public void generatedArrivalEventsToEventList(int quantity, EventList list) {
        for (int i = 0; i < quantity; i++) {
            long sample = (long) normalDistribution.sample();
            Event event = new Event(this.eventType, Instant.ofEpochSecond(sample));
            list.addEvent(event);
        }
    }
    public static void main (String[] args) {
        ArrivalProcess process = new ArrivalProcess();
        EventList list = new EventList();

        process.generatedArrivalEventsToEventList(10, list);

        while (!list.isEmpty()) {
            Event event = list.pollEvent();
            System.out.println(event);
        }
    }
}
