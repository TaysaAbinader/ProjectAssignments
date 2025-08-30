import java.util.LinkedList;
import java.util.Scanner;


public class Queue {
    private LinkedList<Customer> queueLinkedList;

    public Queue () {
        queueLinkedList = new LinkedList<>();
    }

    public void enterQueue (Customer customer) {
        customer.updateStartTime();
        queueLinkedList.addFirst(customer);
    }

    public Customer leaveQueue () {
        if (queueLinkedList.isEmpty()) {
            System.err.println ("Error: Queue is empty");
        }
        Customer removedCustomer = queueLinkedList.removeLast();
        removedCustomer.updateEndTime();
        return removedCustomer;
    }

    public String toString() {
        return queueLinkedList.toString();
    }

    public static void main(String[] args) {

        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Accepted options:");
        System.out.println("- \"queue\": Add a new customer to the queue");
        System.out.println("- \"dequeue\": Remove the oldest customer from the queue");
        System.out.println("- \"list\": List all customers in the queue");
        System.out.println("- \"exit\": Exit program");

        // Loop
        while (true) {
            System.out.println("What do you want to do?");
            String action = scanner.nextLine();
            if (action.equals("queue")) {
                Customer newCustomer = new Customer();
                System.out.println("Added customer " + newCustomer.getId() + " to the queue");
                queue.enterQueue(newCustomer);
            } else if (action.equals("dequeue")) {
                Customer removedCustomer = queue.leaveQueue();
                System.out.println("Removed customer " + removedCustomer.getId() + " from the queue");
                System.out.println("Time spent: " + removedCustomer.timeSpent() + " ns");
            } else if (action.equals("list")) {
                System.out.println(queue.toString());
            } else if (action.equals("exit")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.err.println("Error: wrong command \"" + action + '\'');
            }
        }
    }
}


