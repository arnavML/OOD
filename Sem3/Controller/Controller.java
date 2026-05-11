package Sem3.Controller;

import Sem3.Model.DTOs.CustomerDTO;
import Sem3.Model.Domain.Bike;
import Sem3.Model.Domain.Customer;
import Sem3.Model.Domain.RepairOrder;
import Sem3.Model.Domain.RepairTask;
import Sem3.Model.Logic.CustomerRegistry;
import Sem3.Model.Logic.RepairOrderRegistry;
import Sem3.View.Printer;
import Sem3.Model.Mapper.*;

public class Controller { //The Controller class is responsible for handling the logic of the application, including searching for customers, creating repair orders, and managing the details of the repair orders. It interacts with the CustomerRegistry to find customers, the RepairOrderRegistry to manage repair orders, and the Printer to print repair order details. It also stores the currently selected customer and repair order to facilitate getting their details without having to search for them again.

    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private Printer printer;
    private Customer currentCustomer; // Store the currently selected customer so that we can use it when getting details back to the view without always having to search for it again
    private RepairOrder repairOrder; // Store the currently selected repair order so that we can use it when getting details back to the view without always having to search for it again

    public Controller(CustomerRegistry customerRegistry, RepairOrderRegistry repairOrderRegistry, Printer printer) { // Initializes the controller with the given customer registry, repair order registry, and printer. It also sets up some mock data for testing purposes.
        this.customerRegistry = customerRegistry;
        this.repairOrderRegistry = repairOrderRegistry;
        this.printer = printer;
        setupMockData();
    }

    private void setupMockData() { // Sets up some mock data for testing purposes by adding several customers to the customer registry. Each customer has a unique name, customer number, email, and bike.
        //Customer Data MADE WITH AI

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

    //Method For searching for a customer by their phone number, which will be used in the View when the receptionist/technician searches for a customer
    public CustomerDTO search(int number) {
        //Finds the customer in the registry by their phone number and returns the customer object if found, otherwise returns null, and also sets the currentCustomer variable to the found customer so that we can use it later without having to search for it again
        currentCustomer =  customerRegistry.findCustomerByNumber(number);
        CustomerDTO customerDTO = CustomerMapper.toDTO(currentCustomer);
        return customerDTO;
    }

    public void createRepairOrder(int number, String description, String date, String status) { //Creates a new repair order for the given customer with the provided description and date. It also sets the current repair order variable to the newly created repair order so that we can use it later without having to search for it again.
        Customer customer = customerRegistry.findCustomerByNumber(number);
        RepairOrder newRepairOrder = new RepairOrder(customer, number, description, date, status);
        repairOrderRegistry.addRepairOrder(newRepairOrder);
        this.repairOrder = newRepairOrder;
    }

}

