package Sem3.model.mapper;
import java.util.ArrayList;
import java.util.List;

import Sem3.model.dto.RepairOrderDTO;
import Sem3.model.dto.RepairTaskDTO;
import Sem3.model.domain.RepairOrder;
import Sem3.model.domain.RepairTask;


public class RepairOrderMapper {
    
    public static RepairOrderDTO toDTO(RepairOrder repairOrder) {
        List<RepairTaskDTO> repairTasks = new ArrayList<>();
        for (RepairTask task : repairOrder.getRepairTasks()) {
            repairTasks.add(RepairTaskMapper.toDTO(task));
        }
        return new RepairOrderDTO(CustomerMapper.toDTO(repairOrder.getCustomer()), BikeMapper.toDTO(repairOrder.getBike()), repairOrder.getOrderPhoneNumber(), repairOrder.getDescription(), repairOrder.getTotalCost(), repairOrder.getStatus(), repairOrder.getDate(), repairOrder.getDiagnosticReport(), repairTasks);
    }
}
