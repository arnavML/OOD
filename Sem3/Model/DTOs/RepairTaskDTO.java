package Sem3.Model.DTOs;

public class RepairTaskDTO {
    private String description;
    private double cost;

    public RepairTaskDTO(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }
}
