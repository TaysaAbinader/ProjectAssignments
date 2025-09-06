package OrientationChapter_1_3;

// Clock is a singleton object, which means its constructor is private.
public class Clock {
    private static Clock instance = null;
    private long time;
    
    private Clock() {
        this.time = 0;
    }
    
     public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    // Other methods and properties of the Singleton class

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return this.time;
    }

    public void tickClock() {
        this.time++;
    }

    public static void main(String[] args) {
        Clock clock1 = Clock.getInstance();
        Clock clock2 = Clock.getInstance();

        System.out.println("Check if Clock.getInstance() returns the same object: " + (clock1 == clock2));
        System.out.println("Clock 1 address: " + clock1);
        System.out.println("Clock 2 address: " + clock2);

        System.out.println("Clock initial time: " + clock1.getTime());
        clock1.tickClock();
        System.out.println("Clock after tick: " + clock1.getTime());

        // Modify the clock to a different time.
        clock1.setTime(100);
        System.out.println("Clock (1) after update: " + clock1.getTime());
        System.out.println("Clock (2) after update: " + clock2.getTime());
    }
}
