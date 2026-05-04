package Sem3;

public class Controller {

    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private Printer printer;

    public Controller(CustomerRegistry customerRegistry, RepairOrderRegistry repairOrderRegistry, Printer printer) {
        this.customerRegistry = customerRegistry;
        this.repairOrderRegistry = repairOrderRegistry;
        this.printer = printer;
        System.out.println("Starting the Controller...");
        setupMockData();
    }

    private void setupMockData() {
        //MADE WITH AI

        // Astrid with a classic Swedish Crescent bike
        customerRegistry.addCustomer(new Customer("Astrid Lindgren", 708123456, "astrid.l@example.se", new Bike("Crescent", "Classic", "CR1001", 708123456)));

        // Björn with a classic Swedish Monark bike
        customerRegistry.addCustomer(new Customer("Björn Borg", 723456789, "bjorn.b@tennis.se", new Bike("Monark", "Karin", "MO5522", 723456789)));

        // Zlatan with a mountain bike
        customerRegistry.addCustomer(new Customer("Zlatan Ibrahimovic", 739988776, "zlatan@football.se", new Bike("Trek", "Marlin 8", "TRK909", 739988776)));

        // Alicia with a hybrid commuter bike
        customerRegistry.addCustomer(new Customer("Alicia Vikander", 764554433, "alicia.v@movies.se", new Bike("Specialized", "Sirrus", "SP8871", 764554433)));

        // Tim with a fast Nishiki bike
        customerRegistry.addCustomer(new Customer("Tim Bergling", 701122334, "tim.b@music.se", new Bike("Nishiki", "Pro SLD", "NI4433", 701122334)));
    }

    public Customer search(int number) {
        // Implement search functionality here
        System.out.println("Controller is searching for number: " + number);
        // Example: Use customerRegistry or repairOrderRegistry to perform the search
        return customerRegistry.findCustomerByNumber(number); // Replace with actual search logic
    }
    public void makeRepairOrder(Customer customer, String description, String date /*later add: String status*/) {

        RepairOrder newOrder = new RepairOrder(customer.getCustomerNumber(), description, date, "Pending");
        repairOrderRegistry.addRepairOrder(newOrder);
    }
    public RepairOrder findRepairOrdersForCustomer(Customer customer) {
        // Implement logic to find repair orders for the given customer
        return repairOrderRegistry.findRepairOrderCustomerByNumber(customer.getCustomerNumber());
    }
    public void addRepairTaskToOrder(RepairOrder repairOrder, String taskDescription, Double cost) {
        // Implement logic to add a repair task to the given repair order
        repairOrder.addRepairTask(taskDescription, cost);
    }
    public void addDiagnosticReportToOrder(RepairOrder repairOrder, String diagnosticReport) {
        // Implement logic to add a diagnostic report to the given repair order
        repairOrder.setDiagnosticReport(diagnosticReport);
    }
    
    public void printRepairOrderDetails(RepairOrder repairOrder) {
        // Implement logic to print the details of the given repair order
        printer.printRepairOrderDetails(repairOrder);
    }

}

