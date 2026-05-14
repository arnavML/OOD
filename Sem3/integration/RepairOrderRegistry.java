package Sem3.integration;
import java.util.ArrayList;
import java.util.List;

import Sem3.model.domain.RepairOrder;

public class RepairOrderRegistry { //The RepairOrderRegistry class is responsible for managing a collection of repair orders in the system. It provides methods for adding repair orders, finding repair orders by the customer's phone number, and retrieving a list of all repair orders.

    private List<RepairOrder> repairOrders = new ArrayList<>();
    
    public RepairOrderRegistry(){ // Initializes the repair order registry with an empty list of repair orders
        this.repairOrders = new ArrayList<>();
    }
    
    public List<RepairOrder> getAllRepairOrders() { // Returns a list of all repair orders in the registry
        return repairOrders;
    }
    
    public void addRepairOrder(RepairOrder repairOrder) { // Adds a new repair order to the registry by adding it to the list of repair orders
        repairOrders.add(repairOrder); 
    }

    public RepairOrder findRepairOrderCustomerByNumber(int number) { // Finds a repair order in the registry by the customer's phone number
        for (RepairOrder repairOrder : repairOrders) {
            if (repairOrder.getOrderPhoneNumber() == number) {
                return repairOrder;
            }
        }
        return null;
    }
}
