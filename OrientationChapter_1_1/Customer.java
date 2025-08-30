import java.util.concurrent.TimeUnit;

public class Customer {
    private static int idIncrementor = 1;
    private int id;
    private long startTime = -1;
    private long endTime = -1;

    public Customer () {
        this.id = idIncrementor++;
    }

    public int getId () {
        return this.id;
    }

    public void updateStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime () {
        return this.startTime;
    }

    public void updateEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    public long getEndTime () {
        return this.endTime;
    }

    public long timeSpentInSeconds () {
        long timeSpent = (this.endTime - this.startTime);
        long timeInSecs = timeSpent/1000;
        return timeInSecs;
    }

    public static void main(String[] args) {
        Customer customerName1 = new Customer();
        customerName1.updateStartTime();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Customer customerName2 = new Customer();
        customerName2.updateStartTime();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        customerName1.updateEndTime();
        customerName1.timeSpentInSeconds();

        customerName2.updateEndTime();
        customerName2.timeSpentInSeconds();

        System.out.println("Id: " + customerName1.id + ", time spent: " + customerName1.timeSpentInSeconds());
        System.out.println("Id: " + customerName2.id + ", time spent: " + customerName2.timeSpentInSeconds());
    }

}
