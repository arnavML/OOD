package Sem3.View;

import Sem3.Controller.Controller;

public class Viewer { //The View class is responsible for interacting with the user and displaying information. It has a reference to the Controller, which it uses to perform actions and retrieve data to display.

    private Controller controller;

    public Viewer(Controller controller) { // Initializes the view with the given controller. It also sets up some mock data for testing purposes.
        this.controller = controller;
        System.out.println("Starting the View...");
    }
    private int numberToSearch = 739988776; // Example number to search
    private String repairDescription = "Routine maintenance"; // Example repair description
    private String date = "2024-06-01"; // Example date


    public void Start() { // Starts the view by calling the basic flow of the application, which includes receiving a bike from a customer, performing diagnostics and repair, and checking out the customer.
        basicFlow();
    }
    private void basicFlow() { //Runs the sections of the basic flow
        receiveBikeFromCustomer();
        performDiagnosticsAndRepair();
        checkoutCustomer();
    }

    private void receiveBikeFromCustomer() { // Implements the logic for receiving a bike from a customer, which includes searching for the customer by their phone number, displaying their details, and creating a repair order if the details are correct.
        search(numberToSearch);
        System.out.println("Showing details for customer to Repair Shop Technician...");
        showCustomerDetails();
        showBikeDetails();
        if (correctDetails()){
            System.out.println("Details are correct, making repair order..." + "\n");
            makeRepairOrder(repairDescription, date, "Newly Created");
        }
        
    }

    private void performDiagnosticsAndRepair() { // Implements the logic for performing diagnostics and repair on the customer's bike
        showRepairOrdersForCustomer();
        addDiagnosticReportToOrder("The bike needs a new wheel, brake pads, and battery.");
        addRepairTaskToOrder("new Wheel", 100.0);
        addRepairTaskToOrder("new Brake Pads", 150.0);
        addRepairTaskToOrder("new Battery", 40.0);
        controller.updateRepairOrderStatus("Ready for approval");
    }

    private void checkoutCustomer() { //Code for checking out the customer, which includes showing the diagnostic report and repair tasks to the customer, and then printing the details of the repair order for the customer to see before they leave the shop
        showDiagnosticReportForOrder();
        controller.updateRepairOrderStatus("Accepted");
        // just have the printer print the details of the repair order, including the diagnostic report and the repair tasks with their costs
        System.out.println("Printing Repair Order Details..." + "\n");
        controller.printRepairOrderDetails();
    }

    private void search(int number) { // Searches for a customer by their phone number
        System.out.println("Searching for number: " + number);
        System.out.println();
        controller.search(number); // This will set the currentCustomer in the controller, which we can then use to get details back to the view without having to search for it again
    }

    private void showCustomerDetails() { // Displays the details of the current customer, which includes their name and email. It gets this information from the controller.
        System.out.println("Customer Details:");
        System.out.println("Customer Name: " + controller.customerName());
        System.out.println("Customer Email: " + controller.customerEmail());
        System.out.println();
    }
    private void showBikeDetails() { // Displays the details of the current customer's bike, which includes the bike's brand, model, and serial number. It gets this information from the controller.
        System.out.println("Bike Details:");
        System.out.println("Bike Brand: " + controller.bikeBrand());
        System.out.println("Bike Model: " + controller.bikeModel());
        System.out.println("Bike Serial Number: " + controller.bikeSerialNumber());
        System.out.println();
    }
    private void showRepairOrderDetails() { // Displays the details of the current repair order, which includes its description, status, and date. It gets this information from the controller.
        System.out.println("Repair Order Details:");
        System.out.println("Description: " + controller.repairDescription());
        System.out.println("Status: " + controller.repairStatus());
        System.out.println("Date: " + controller.repairDate());
        System.out.println();

    }

    private boolean correctDetails() { //Checks if the details of the customer and bike are correct. Just placeholder.
        System.out.println("Checking if the details are correct...");
        System.out.println();
        return true; // Placeholder return value
    }

    private void makeRepairOrder (String description, String date, String status) { //Makes repair order via controller
        controller.makeRepairOrder(description, date, status);
    }

    private void showRepairOrdersForCustomer() { // Implement logic to show repair orders for the given customer to Technician
        controller.findRepairOrdersForCustomer();// This will set the current repair order in the controller, which we can then use to get details back to the view without having to search for it again
        System.out.println("Showing details for customer to Repair Shop Technician...");
        showCustomerDetails();
        showBikeDetails();
        showRepairOrderDetails();
    }

    private void addDiagnosticReportToOrder(String diagnosticReport) { //Adds a diagnostic report to the current repair order via the controller
        controller.addDiagnosticReportToOrder(diagnosticReport);
    }
    private void addRepairTaskToOrder(String taskDescription, Double cost) { //Adds a repair task to the current repair order via the controller
        controller.addRepairTaskToOrder(taskDescription, cost);
    }

    private void showRepairTasksForOrder() { //Shows the repair tasks for the current repair order to the customer. It gets the formatted repair tasks from the controller and prints them to the console.
        System.out.println("Repair Tasks for Repair Order:");
        
        // The View just prints the String provided by the Controller
        System.out.println(controller.getFormattedRepairTasks());
        
        System.out.println();
    }

    private void showDiagnosticReportForOrder() { //Shows the diagnostic report for the current repair order to the customer. It gets the diagnostic report from the controller and prints it to the console.
        System.out.println("Showing diagnostic report for repair order to Customer...");
        System.out.println("Diagnostic Report for Repair Order: " + controller.repairDiagnosticReport());
        System.out.println();
        showRepairTasksForOrder();
    }
}
