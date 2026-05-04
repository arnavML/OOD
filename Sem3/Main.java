package Sem3;

public class Main {
    private static View view;
    private static Controller controller;
    private static CustomerRegistry customerRegistry = new CustomerRegistry();
    private static RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();
    private static Printer printer = new Printer();

    public static void main(String[] args) {
        System.out.println("System is starting...");
        controller = new Controller(customerRegistry, repairOrderRegistry, printer);
        view = new View(controller);
        //later check if controller is not null before using it in View
        view.Start(); // Start the view to accept user input and perform search // Can also start itself in initialization, but this way we have more control over when it starts
    }

}

/*        controller.customerRegistry.addCustomer(new Customer("John Doe", 12345, "john.doe@example.com", new Bike("Giant", "Talon 3", 12345)));
        // Application logic goes here
        Customer customer = view.search(12345);
        System.out.println(customer.getName());
     */