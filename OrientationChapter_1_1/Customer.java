
public class Customer {
    private static int idIncrementor = 1;
    private int id;
    private long startTime;
    private long endTime;

    public Customer () {
        this.id = idIncrementor++;
        this.startTime = System.currentTimeMillis();
        this.endTime = System.currentTimeMillis() + 2000;
    }

    public int getId () {
        return this.id;
    }


    public long getStartTime () {
        return this.startTime;
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
        customerName1.getStartTime();

        Customer customerName2 = new Customer();
        customerName2.getStartTime();

        

        customerName1.getEndTime();
        customerName1.timeSpentInSeconds();

        customerName2.getEndTime();
        customerName2.timeSpentInSeconds();

        System.out.println("Id: " + customerName1.id + ", time spent: " + customerName1.timeSpentInSeconds());
        System.out.println("Id: " + customerName2.id + ", time spent: " + customerName2.timeSpentInSeconds());
        


        
        
    }

}
