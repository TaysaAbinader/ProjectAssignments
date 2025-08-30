import java.util.LinkedList;


public class Queue {
    private LinkedList<Customer> queueLinkedList;

    public Queue () {
        queueLinkedList = new LinkedList<>();
    }

    public void enterQueue (Customer customer) {
        customer.updateStartTime();
        queueLinkedList.addFirst(customer);
    }

    public void leaveQueue () {
        if (queueLinkedList.isEmpty()) {
            System.err.println ("Error: Queue is empty");
        }
        Customer removedCustomer = queueLinkedList.removeLast();
        removedCustomer.updateEndTime();
    }

    public String toString() {
        return queueLinkedList.toString();
    }

    public static void main(String[] args) {

        Queue queue = new Queue();

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        Customer customer4 = new Customer();
        Customer customer5 = new Customer();

        queue.enterQueue(customer1);
        queue.enterQueue(customer2);
        queue.enterQueue(customer3);

        System.out.println(queue);

        queue.leaveQueue();

        queue.enterQueue(customer4);
        queue.enterQueue(customer5);

        System.out.println(queue);

        queue.leaveQueue();
        queue.leaveQueue();

        System.out.println(queue);

        System.out.println("Waiting times:");
        System.out.println("Id: " + customer1.getId() + ", time spent: " + customer1.timeSpent() + " nanoseconds");
        System.out.println("Id: " + customer2.getId() + ", time spent: " + customer2.timeSpent() + " nanoseconds");
        System.out.println("Id: " + customer3.getId() + ", time spent: " + customer3.timeSpent() + " nanoseconds");
    }

}


