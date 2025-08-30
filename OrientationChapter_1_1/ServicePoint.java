import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue;

    public ServicePoint () {
        queue = new LinkedList<>();
    }

    public void addToQueue (Customer customer) {
        customer.updateStartTime();
        queue.addFirst(customer);
    }

    public Customer removeFromQueue () {
        if (queue.isEmpty()) {
            System.err.println ("Error: Queue is empty");
        }
        Customer removedCustomer = queue.removeLast();
        removedCustomer.updateEndTime();
        return removedCustomer;
    }

    public void serve() {
        long serviceTime;

        while (!queue.isEmpty()) {
            Customer removedCustomer = removeFromQueue();
            serviceTime = (long) (Math.random() * 1000);
            try {
                Thread.sleep(serviceTime);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getStackTrace());
            } catch (InterruptedException e) {
                System.err.println(e.getStackTrace());
            }
            System.out.println("Removed customer " + removedCustomer.getId() + " from the queue");
            System.out.println("- Queue time spent: " + removedCustomer.timeSpent() + " ns");
            System.out.println("- Service time spent: " + serviceTime + " ns");
            long totalTimeSpent = removedCustomer.timeSpent() + serviceTime;
            System.out.println("- Total time spent: " + totalTimeSpent + " ns");
        }
    }

    public String toString() {
        return queue.toString();
    }
}
