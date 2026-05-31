package Sem3.view;

import Sem3.controller.Controller;
import Sem3.model.dto.*;

/**
 * The Viewer class is responsible for simulating the user interface of the application. It interacts with the Controller to perform operations such as searching for customers, creating repair orders, and updating repair orders. It also handles exceptions that may occur during these operations and provides user-friendly messages while logging the exceptions for developers.
 */
public class Viewer {

    private Controller controller;

    /**
     * Constructs a new Viewer with the specified controller.
     * @param controller The controller to interact with.
     */
    public Viewer(Controller controller) {
        this.controller = controller;
        System.out.println("System: Starting the View...");
    }
    private int numberToSearch = 739988776; // Example number to search
    private String repairDescription = "Routine maintenance"; // Example repair description
    private String date = "2024-06-01"; // Example date


    /**
     * Starts the view by calling the basic flow of the application, which includes receiving a bike from a customer, performing diagnostics and repair, and checking out the customer.
     */
    public void start() {
        basicFlow();
    }
    private void basicFlow() { //Runs the sections of the basic flow
        System.out.println("System: Running basic flow...");
        CustomerDTO customer = controller.search(numberToSearch);
        System.out.println("System: Returned customer details from search method:");

        System.out.println("Customer search Details:");
        printCustomerDetails(customer);
        printBikeDetails(customer.getBikeDTO());

        System.out.println("System: Details are correct, proceeding to create repair order...");

        controller.createRepairOrder(numberToSearch, repairDescription, date, "pending");
        RepairOrderDTO repairOrderDetails = controller.getRepairOrderDetails(numberToSearch);
        System.out.println("System: Returned repair order details from getRepairOrderDetails method:");
        
        System.out.println("Technician View - Repair Order Details:");
        printRepairOrderDetails(repairOrderDetails);
        printCustomerDetails(customer);
        printBikeDetails(customer.getBikeDTO());

        controller.addDiagnosticReportToOrder(numberToSearch, "The bike needs a new wheel, brake pads, and battery.");
        controller.addRepairTaskToOrder(numberToSearch, "new Wheel", 100.0);
        controller.addRepairTaskToOrder(numberToSearch, "new Brake Pads", 150.0);
        controller.addRepairTaskToOrder(numberToSearch, "new Battery", 40.0);

        repairOrderDetails = controller.getRepairOrderDetails(numberToSearch);
        System.out.println("System: Receptionist View - Updated Repair Order Details:");
        printRepairOrderDetails(repairOrderDetails);
        printRepairTasks(repairOrderDetails);
        controller.updateRepairOrderStatus(numberToSearch, "Accepted");
        
        controller.checkoutCustomer(numberToSearch);
    }

    /**
     * Prints the details of the customer, including their name, customer number, email. This is used in the View to display the customer's information after searching for them.
     * @param customer The CustomerDTO containing the details of the customer to be printed.
     */
    private void printCustomerDetails(CustomerDTO customer) {
        System.out.println("---------------------------------------------------------------------------------" + "\n" + "Customer Details:");
        System.out.println("Name: " + customer.getName());
        System.out.println("Customer Number: " + customer.getOrderNumber());
        System.out.println("Email: " + customer.getEmail());
    }
    /**
     * Prints the details of the customer's bike, including the make, model, serial number, and owner's phone number. This is used in the View to display the bike's information after searching for the customer.
     * @param bike The BikeDTO containing the details of the bike to be printed.
     */
    private void printBikeDetails(BikeDTO bike) {
        System.out.println("---------------------------------------------------------------------------------" + "\n" + "Bike Details:");
        System.out.println("Bike Make: " + bike.getBrand());
        System.out.println("Bike Model: " + bike.getModel());
        System.out.println("Bike Serial Number: " + bike.getSerialNumber());
    }

    /**
     * Prints the details of the repair order, including the customer's number, repair description, date, and status. This is used in the View to display the repair order's information after it has been created.
     * @param repairOrderDetails The RepairOrderDTO containing the details of the repair order to be printed.
     */
    private void printRepairOrderDetails(RepairOrderDTO repairOrderDetails) { //Prints the details of the repair order, including the customer's name, bike make and model, repair description, date, and status. This is used in the View to display the repair order's information after it has been created.
        System.out.println("---------------------------------------------------------------------------------" + "\n" + "Repair Order Details:");
        System.out.println("Customer Number: " + repairOrderDetails.getOrderNumber());
        System.out.println("Repair Description: " + repairOrderDetails.getDescription());
        System.out.println("Repair Date: " + repairOrderDetails.getDate());
        System.out.println("Repair Status: " + repairOrderDetails.getStatus());
        System.out.println("Diagnostic Report: " + repairOrderDetails.getDiagnosticReport());
    }

    /**
     * Prints the details of the repair tasks, including their description and cost. This is used in the View to display the repair
     * @param repairOrderDetails The RepairOrderDTO containing the details of the repair order to be printed.
     */
    private void printRepairTasks(RepairOrderDTO repairOrderDetails) {
        System.out.println("---------------------------------------------------------------------------------" + "\n" + "Repair Tasks:");
        for (RepairTaskDTO task : repairOrderDetails.getRepairTasks()) {
            System.out.println("Task Description: " + task.getDescription());
            System.out.println("Task Cost: " + task.getCost() + "\n");
        }
        System.out.println("Total: " + repairOrderDetails.getTotalCost() + " SEK");
    }
}
