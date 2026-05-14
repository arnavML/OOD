package Sem3.model.domain;
import java.util.ArrayList;
import java.util.List;

public class RepairOrder { //The RepairOrder class represents a repair order for a customer's bike. It contains information about the customer, the bike, the description of the repair, the date of the order, the status of the order, a diagnostic report, and a list of repair tasks associated with the order. It also provides methods to add repair tasks and get the details of the repair order.
    private Customer customer;
    private Bike bike;
    private int orderPhoneNumber;
    private String description;
    private String status;
    private String date;
    private String diagnosticReport;
    private int totalCost;

    private List<RepairTask> repairTasks = new ArrayList<>();

    public List<RepairTask> getRepairTasks() { // Returns the list of repair tasks associated with this repair order
        return repairTasks;
    }

    public void addRepairTask(String taskDescription, Double cost) { // Adds a new repair task to the list of repair tasks for this repair order. It takes in a description of the task and its cost, creates a new RepairTask object, and adds it to the list of repair tasks.
        repairTasks.add(new RepairTask(taskDescription, cost));
    }


    public RepairOrder(Customer customer, int orderPhoneNumber, String description, String date, String status) { // Constructor for the RepairOrder class. It takes in a Customer object, the customer's phone number, a description of the repair, the date of the order, and the status of the order. It initializes the corresponding fields of the RepairOrder object and also sets the bike field to the bike associated with the customer.    
        this.customer = customer;
        this.bike = customer.getBike();
        this.orderPhoneNumber = orderPhoneNumber;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public int getTotalCost() { // Returns the total cost of the repair order by summing up the cost of all the repair tasks associated with this order
        int totalCost = 0;
        for (RepairTask task : repairTasks) {
            totalCost += task.getCost();
        }
        return totalCost;
    }

    public int getOrderPhoneNumber() { // Returns the phone number associated with this repair order
        return orderPhoneNumber;
    }

    public void setOrderPhoneNumber(int orderPhoneNumber) { // Sets the phone number associated with this repair order to the given value
        this.orderPhoneNumber = orderPhoneNumber;
    }

    public String getDescription() { // Returns the description of the repair order
        return description;
    }

    public void setDescription(String description) { // Sets the description of the repair order to the given value
        this.description = description;
    }

    public String getDate() { // Returns the date of the repair order
        return date;
    }
    public void setDate(String date) { // Sets the date of the repair order to the given value
        this.date = date;
    }


    public String getStatus() { // Returns the status of the repair order
        return status;
    }

    public void setStatus(String status) { // Sets the status of the repair order to the given value
        this.status = status;
    }

    public String getDiagnosticReport() { // Returns the diagnostic report of the repair order
        return diagnosticReport;
    }

    public void setDiagnosticReport(String diagnosticReport) { // Sets the diagnostic report of the repair order to the given value
        this.diagnosticReport = diagnosticReport;
    }

    public Customer getCustomer() { // Returns the customer associated with this repair order
        return customer;
    }
    public Bike getBike() { // Returns the bike associated with this repair order
        return bike;
    }


}
