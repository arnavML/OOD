package Sem3;

public class View {

    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        System.out.println("Starting the View...");
    }
    private Customer currentCustomer;
    private int numberToSearch = 739988776; // Example number to search
    private String repairDescription = "Routine maintenance"; // Example repair description
    private String date = "2024-06-01"; // Example date


    public void Start() {
        basicFlow();
    }
    private void basicFlow() {
        receiveBikeFromCustomer();
        performDiagnosticsAndRepair();
        checkoutCustomer();
    }

    private void receiveBikeFromCustomer() {
        currentCustomer = search(numberToSearch);
        showCustomerDetails(currentCustomer);
        correctDetails(currentCustomer);
        makeRepairOrder(currentCustomer, repairDescription, date);
    }
    private void performDiagnosticsAndRepair() {
        RepairOrder repairOrder = findRepairOrdersForCustomer(currentCustomer);
        showRepairOrdersForCustomer(currentCustomer);
        addDiagnosticReportToOrder(repairOrder, "The bike needs a new wheel, brake pads, and battery.");
        addRepairTaskToOrder(repairOrder, "new Wheel", 100.0);
        addRepairTaskToOrder(repairOrder, "new Brake Pads", 150.0);
        addRepairTaskToOrder(repairOrder, "new Battery", 40.0);
    }
    private void checkoutCustomer() {
        RepairOrder repairOrder = findRepairOrdersForCustomer(currentCustomer);
        showDiagnosticReportForOrder(repairOrder);
        // just have the printer print the details of the repair order, including the diagnostic report and the repair tasks with their costs
        controller.printRepairOrderDetails(repairOrder);
    }

    private Customer search(int number) {
        // Implement search functionality here
        System.out.println("Searching for number: " + number);
        return controller.search(number); // Replace with actual customer object if found
    }

    private void showCustomerDetails(Customer customer) {
        System.out.println("Showing details for customer to Repair Shop Receptionist...");
        System.out.println("Customer Details:");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Email: " + customer.getEmail());
        System.out.println();
        System.out.println("Bike Details:");
        System.out.println("Bike Brand: " + customer.getBike().getBrand());
        System.out.println("Bike Model: " + customer.getBike().getModel());
        System.out.println("Bike Serial Number: " + customer.getBike().getSerialNumber());
        System.out.println();
    }

    private boolean correctDetails(Customer customer) {
        // Implement logic to check if the details are correct
        return true; // Placeholder return value
    }

    private void makeRepairOrder (Customer customer, String description, String date /*later add: String status*/) {
        // Implement logic to update customer details
        controller.makeRepairOrder(customer, description, date);
    }

    private void showRepairOrdersForCustomer(Customer customer) {
        // Implement logic to show repair orders for the given customer
        RepairOrder repairOrder = findRepairOrdersForCustomer(customer);
        System.out.println("Showing details for customer to Repair Shop Technician...");
        System.out.println("Repair Order Details:");
        System.out.println("Customer Number: " + repairOrder.getOrderPhoneNumber());
        System.out.println("Description: " + repairOrder.getDescription());
        System.out.println("Status: " + repairOrder.getStatus());
        System.out.println("Date: " + repairOrder.getDate());
        System.out.println();
    }

    private RepairOrder findRepairOrdersForCustomer(Customer customer) {
        // Implement logic to find repair orders for the given customer
        return controller.findRepairOrdersForCustomer(customer);
    }

    private void addDiagnosticReportToOrder(RepairOrder repairOrder, String diagnosticReport) {
        // Implement logic to add a diagnostic report to the given repair order
        controller.addDiagnosticReportToOrder(repairOrder, diagnosticReport);
    }
    private void addRepairTaskToOrder(RepairOrder repairOrder, String taskDescription, Double cost) {
        // Implement logic to add a repair task to the given repair order
        controller.addRepairTaskToOrder(repairOrder, taskDescription, cost);
    }

    private void showRepairTasksForOrder(RepairOrder repairOrder) {
        Double totalCost = 0.0;
        // Implement logic to show repair tasks for the given repair order
        System.out.println("Repair Tasks for Repair Order:");
        for (RepairTask task : repairOrder.getRepairTasks()) {
            System.out.println("Task: " + task.getDescription());
            System.out.println("Cost: " + task.getCost());
            System.out.println();
            totalCost += task.getCost();
        }
        System.out.println("Total Cost: " + totalCost);
        System.out.println();
    }

    private void showDiagnosticReportForOrder(RepairOrder repairOrder) {
        // Implement logic to show the diagnostic report for the given repair order
        System.out.println("Diagnostic Report for Repair Order:");
        System.out.println(repairOrder.getDiagnosticReport());
        System.out.println();
        showRepairTasksForOrder(repairOrder);
    }
}
