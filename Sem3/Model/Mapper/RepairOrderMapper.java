package Sem3.Model.Mapper;
import java.util.ArrayList;
import java.util.List;

import Sem3.Model.DTOs.RepairTaskDTO;
import Sem3.Model.Domain.RepairOrder;
import Sem3.Model.Domain.RepairTask;
import Sem3.Model.DTOs.RepairOrderDTO;


public class RepairOrderMapper {
    
    public static RepairOrderDTO toDTO(RepairOrder repairOrder) {
        List<RepairTaskDTO> repairTasks = new ArrayList<>();
        double totalCost = 0.0;
        for (RepairTask repairTask : repairOrder.getRepairTasks()) {
            repairTasks.add(RepairTaskMapper.toDTO(repairTask));
            totalCost += repairTask.getCost();
        }

        return new RepairOrderDTO(CustomerMapper.toDTO(repairOrder.getCustomer()), BikeMapper.toDTO(repairOrder.getBike()), repairOrder.getOrderPhoneNumber(), repairOrder.getDescription(), totalCost, repairOrder.getStatus(), repairOrder.getDate(), repairOrder.getDiagnosticReport(), repairTasks);
    }
}
