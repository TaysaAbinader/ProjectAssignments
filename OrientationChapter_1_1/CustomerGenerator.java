import java.util.Scanner;

public class CustomerGenerator {
    private ServicePoint servicePoint;

    public CustomerGenerator(ServicePoint servicePoint) {
        this.servicePoint = servicePoint;
    }

    public void generateCustomers(int amount) {
        for (int i = 0; i < amount; i++) {
            Customer customer = new Customer();
            System.out.println("Adding customer " + customer.getId() + "  to the queue");
            servicePoint.addToQueue(customer);
        }
    }

    public void serve() {
        servicePoint.serve();
    }

    public static void main(String[] args) {
        CustomerGenerator generator = new CustomerGenerator(new ServicePoint());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount of customers to queue:");
        int amount = Integer.parseInt(scanner.nextLine());

        // Add the given amount of customers to the queue.
        generator.generateCustomers(amount);

        // Serve all customers.
        generator.serve();
    }
}
