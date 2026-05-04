package Sem3;
import java.util.ArrayList;
import java.util.List;

public class RepairOrderRegistry {

    private List<RepairOrder> repairOrders = new ArrayList<>();
    
    public RepairOrderRegistry(){
        this.repairOrders = new ArrayList<>();
    }
    
    public List<RepairOrder> getAllRepairOrders() {
        return repairOrders;
    }
    
    public void addRepairOrder(RepairOrder repairOrder) {
        repairOrders.add(repairOrder);
    }

    public RepairOrder findRepairOrderCustomerByNumber(int number) {
        for (RepairOrder repairOrder : repairOrders) {
            if (repairOrder.getOrderPhoneNumber() == number) {
                return repairOrder;
            }
        }
        return null;
    }
}
