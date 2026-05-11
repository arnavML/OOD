package Sem3.Model.Mapper;
import Sem3.Model.DTOs.RepairTaskDTO;
import Sem3.Model.Domain.RepairTask;

public class RepairTaskMapper {
    
    public static RepairTaskDTO toDTO(RepairTask repairTask) {
        return new RepairTaskDTO(repairTask.getDescription(), repairTask.getCost());
    }
}
