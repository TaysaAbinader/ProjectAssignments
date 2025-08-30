public class Customer {
    private static int idIncrementor = 1;
    private int id;
    private long startTime;
    private long endTime;

    public Customer () {
        this.id = idIncrementor++;
    }

    public int getId () {
        return this.id;
    }

    public void updateStartTime() {
        this.startTime = System.nanoTime();
    }

    public long getStartTime () {
        return this.startTime;
    }

    public void updateEndTime() {
        this.endTime = System.nanoTime();
    }

    public long getEndTime () {
        return this.endTime;
    }

    public long timeSpent() {
        long timeSpent = (this.endTime - this.startTime);
        return timeSpent;
    }

    @Override
    public String toString() {
        return "Customer " + id;
    }

    public static void main(String[] args) {
        Customer customerName1 = new Customer();
        customerName1.updateStartTime();

        Customer customerName2 = new Customer();
        customerName2.updateStartTime();

        customerName1.updateEndTime();
        customerName2.updateEndTime();

        System.out.println("Id: " + customerName1.id + ", time spent: " + customerName1.timeSpent() + " nanoseconds");
        System.out.println("Id: " + customerName2.id + ", time spent: " + customerName2.timeSpent() + " nanoseconds");
    }

}
