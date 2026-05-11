package Sem3.View;

import Sem3.Controller.Controller;
import Sem3.Model.DTOs.BikeDTO;
import Sem3.Model.DTOs.CustomerDTO;

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
        System.out.println("Running basic flow...");
        CustomerDTO customer = controller.search(numberToSearch);
        System.out.println("Returned customer details from search method:");

        System.out.println("Customer search Details:");
        printCustomerDetails(customer);
        printBikeDetails(customer.getBike());

        System.out.println("Details are correct, proceeding to create repair order...");

        controller.createRepairOrder(customer, repairDescription, date, "pending");
    }

    private void printCustomerDetails(CustomerDTO customer) { //Prints the details of the customer, including their name, customer number, email, and bike details. This is used in the View to display the customer's information after searching for them.
        System.out.println("---------------------------------------------------------------------------------" + "\n" + "Customer Details:");
        System.out.println("Name: " + customer.getName());
        System.out.println("Customer Number: " + customer.getCustomerNumber()); //perhaps redundant since it's the same as the phone number, but it could be useful if we want to change the way we identify customers in the future
        System.out.println("Email: " + customer.getEmail());
    }
    private void printBikeDetails(BikeDTO bike) { //Prints the details of the customer's bike, including the make, model, serial number, and owner's phone number. This is used in the View to display the bike's information after searching for the customer.
        System.out.println("---------------------------------------------------------------------------------" + "\n" + "Bike Details:");
        System.out.println("Bike Make: " + bike.getBrand());
        System.out.println("Bike Model: " + bike.getModel());
        System.out.println("Bike Serial Number: " + bike.getSerialNumber());
    }
}
