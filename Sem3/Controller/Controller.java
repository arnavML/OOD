package Sem3.controller;

import Sem3.view.Printer;
import Sem3.integration.CustomerRegistry;
import Sem3.integration.RepairOrderRegistry;
import Sem3.model.domain.*;
import Sem3.model.dto.*;
import Sem3.model.mapper.*;

public class Controller { //The Controller class is responsible for handling the logic of the application, including searching for customers, creating repair orders, and managing the details of the repair orders. It interacts with the CustomerRegistry to find customers, the RepairOrderRegistry to manage repair orders, and the Printer to print repair order details. It also stores the currently selected customer and repair order to facilitate getting their details without having to search for them again.

    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private Printer printer;


    public Controller(CustomerRegistry customerRegistry, RepairOrderRegistry repairOrderRegistry, Printer printer) { // Initializes the controller with the given customer registry, repair order registry, and printer. It also sets up some mock data for testing purposes.
        this.customerRegistry = customerRegistry;
        this.repairOrderRegistry = repairOrderRegistry;
        this.printer = printer;
    }

    //Method For searching for a customer by their phone number, which will be used in the View when the receptionist/technician searches for a customer
    public CustomerDTO search(int number) {
        //Finds the customer in the registry by their phone number and returns the customer object if found, otherwise returns null, and also sets the currentCustomer variable to the found customer so that we can use it later without having to search for it again
        CustomerDTO customerDTO = CustomerMapper.toDTO(customerRegistry.findCustomerByNumber(number));
        return customerDTO;
    }

    public void createRepairOrder(int number, String description, String date, String status) { //Creates a new repair order for the given customer with the provided description and date. It also sets the current repair order variable to the newly created repair order so that we can use it later without having to search for it again.
        RepairOrder newRepairOrder = new RepairOrder(customerRegistry.findCustomerByNumber(number), number, description, date, status);
        repairOrderRegistry.addRepairOrder(newRepairOrder);
    }

    public RepairOrderDTO getRepairOrderDetails(int number) { //Gets the details of the current repair order and returns it as a RepairOrderDTO. This is used in the View to display the details of the repair order after it has been created.
        return RepairOrderMapper.toDTO(repairOrderRegistry.findRepairOrderCustomerByNumber(number));
    }

    private RepairOrder findRepairOrderByCustomerNumber(int number) { //Finds a repair order in the registry by the customer's phone number and returns it. This is used internally in the Controller to find the repair order associated with a customer when we need to get or update its details.);
        return repairOrderRegistry.findRepairOrderCustomerByNumber(number);
    }

    public void addDiagnosticReportToOrder(int number, String diagnosticReport) { //Adds a diagnostic report to the current repair order. This is used in the View to add a diagnostic report to the repair order after it has been created.
        RepairOrder repairOrder = findRepairOrderByCustomerNumber(number);
        repairOrder.setDiagnosticReport(diagnosticReport);
    }
    public void addRepairTaskToOrder(int number, String taskDescription, double cost) { //Adds a repair task to the current repair order. This is used in the View to add a repair task to the repair order after it has been created.
        RepairOrder repairOrder = findRepairOrderByCustomerNumber(number);
        repairOrder.addRepairTask(taskDescription, cost);
    }

    public void updateRepairOrderStatus(int number, String newStatus) { //Updates the status of the current repair order. This is used in the View to update the status of the repair order after it has been created.
        RepairOrder repairOrder = findRepairOrderByCustomerNumber(number);
        repairOrder.setStatus(newStatus);
    }

    public void checkoutCustomer(int number) { //Checks out the customer by printing the details of the repair order and the total cost of the repair. This is used in the View to check out the customer after the repair has been completed.
        RepairOrder repairOrder = findRepairOrderByCustomerNumber(number);
        printer.printRepairOrderDetails(RepairOrderMapper.toDTO(repairOrder));
    }
}

