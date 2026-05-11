package Sem3.Controller;

import Sem3.Model.Domain.Bike;
import Sem3.Model.Domain.Customer;
import Sem3.Model.Domain.RepairOrder;
import Sem3.Model.Domain.RepairTask;
import Sem3.Model.Logic.CustomerRegistry;
import Sem3.Model.Logic.RepairOrderRegistry;
import Sem3.View.Printer;

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
    public Customer search(int number) {
        //Finds the customer in the registry by their phone number and returns the customer object if found, otherwise returns null, and also sets the currentCustomer variable to the found customer so that we can use it later without having to search for it again
        currentCustomer =  customerRegistry.findCustomerByNumber(number);
        return currentCustomer;
    }

    //Methods for getting the details of the current customer their bike, and the repair info, which will be used in the View to display the customer's details after searching for them
    //Methods have been writen in the classes to return the data in a better way but didnt use this time.
    //Customer details
    public String customerName() { // Returns the name of the current customer, which will be used in the View to display the customer's name after searching for them
        return currentCustomer.getName();
    }
    public String customerEmail() { // Returns the email of the current customer, which will be used in the View to display the customer's email after searching for them
        return currentCustomer.getEmail();
    }

    //Bike details
    public String bikeBrand() { // Returns the brand of the current customer's bike, which will be used in the View to display the bike's brand after searching for the customer
        return currentCustomer.getBike().getBrand();
    }
    public String bikeModel() { // Returns the model of the current customer's bike, which will be used in the View to display the bike's model after searching for the customer
        return currentCustomer.getBike().getModel();
    }
    public String bikeSerialNumber() { // Returns the serial number of the current customer's bike, which will be used in the View to display the bike's serial number after searching for the customer
        return currentCustomer.getBike().getSerialNumber();
    }

    //Repair details
    public String repairDescription() { // Returns the description of the current repair order, which will be used in the View to display the repair order's description after creating a repair order for the customer
        return repairOrder.getDescription();
    }
    public String repairStatus() { // Returns the status of the current repair order, which will be used in the View to display the repair order's status after creating a repair order for the customer
        return repairOrder.getStatus();
    }
    public String repairDate() { // Returns the date of the current repair order, which will be used in the View to display the repair order's date after creating a repair order for the customer
        return repairOrder.getDate();
    }
    public String repairDiagnosticReport() { // Returns the diagnostic report of the current repair order, which will be used in the View to display the repair order's diagnostic report after performing diagnostics on the customer's bike
        return repairOrder.getDiagnosticReport();
    }



    public void makeRepairOrder(String description, String date, String status) { // logic to create a new repair order for the current customer with the given description, date, and status, and add it to the repair order registry. It also sets the current repair order variable to the newly created repair order so that we can use it later without having to search for it again
        RepairOrder newOrder = new RepairOrder(currentCustomer,currentCustomer.getCustomerNumber(), description, date, status);
        repairOrderRegistry.addRepairOrder(newOrder);
    }

    public RepairOrder findRepairOrdersForCustomer() { // logic to find repair orders for the given customer and return them. It also sets the current repair order variable to the found repair order so that we can use it later without having to search for it again
        // Implement logic to find repair orders for the given customer
        repairOrder = repairOrderRegistry.findRepairOrderCustomerByNumber(currentCustomer.getCustomerNumber());
        return repairOrder;
    }

    public void addDiagnosticReportToOrder(String diagnosticReport) { // logic to add a diagnostic report to the given repair order
        // Implement logic to add a diagnostic report to the given repair order
        repairOrder.setDiagnosticReport(diagnosticReport);
    }

    public void addRepairTaskToOrder(String taskDescription, Double cost) { // logic to add a repair task to the given repair order

        // Implement logic to add a repair task to the given repair order
        repairOrder.addRepairTask(taskDescription, cost);
    }
    
    public void printRepairOrderDetails() { // logic to print the details of the given repair order by using the Printer class. It gets the details of the current customer and repair order, formats the repair tasks, and then calls the printer to print all the details.
        // Implement logic to print the details of the given repair order
        printer.printRepairOrderDetails(currentCustomer.getCustomerNumber(), repairOrder.getDescription(), repairOrder.getDate(), repairOrder.getStatus(), repairOrder.getDiagnosticReport(), getFormattedRepairTasks());
    }

    public String getFormattedRepairTasks() { // Helper method to format the repair tasks and their costs into a string that can be printed by the Printer class. It iterates through the list of repair tasks in the current repair order, formats each task's description and cost, and calculates the total cost of all tasks. It then returns a string containing the details of each task and the total cost.

        StringBuilder taskDetails = new StringBuilder();
        double totalCost = 0.0;
        
        // The Controller handles the Model objects (RepairTask) and the math
        for (RepairTask task : repairOrder.getRepairTasks()) {
            taskDetails.append("Task: ").append(task.getDescription()).append("\n");
            taskDetails.append("Cost: ").append(task.getCost()).append("\n\n");
            totalCost += task.getCost();
        }
        
        taskDetails.append("Total Cost: ").append(totalCost);
        
        return taskDetails.toString();
    }

    public void updateRepairOrderStatus(String status) { // Implement logic to update the status of the given repair order
        repairOrder.setStatus(status);
    }

}

