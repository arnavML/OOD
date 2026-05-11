package Sem3.Model.DTOs;

import java.util.ArrayList;
import java.util.List;

public class RepairOrderDTO {
    private CustomerDTO customerDTO;
    private BikeDTO bikeDTO;
    private int orderPhoneNumber;
    private String description;
    private double totalCost; //new so we have total
    private String status;
    private String date;
    private String diagnosticReport;

    private List<RepairTaskDTO> repairTasks = new ArrayList<>();

    public List<RepairTaskDTO> getRepairTasks() {
        return repairTasks;
    }
    
    public RepairOrderDTO(CustomerDTO customerDTO, BikeDTO bikeDTO, int orderPhoneNumber, String description, double totalCost, String status, String date, String diagnosticReport, List<RepairTaskDTO> repairTasks) {
        this.customerDTO = customerDTO;
        this.bikeDTO = bikeDTO;
        this.orderPhoneNumber = orderPhoneNumber;
        this.description = description;
        this.totalCost = totalCost;
        this.status = status;
        this.date = date;
        this.diagnosticReport = diagnosticReport;
        this.repairTasks = repairTasks;
    }

    public int getOrderPhoneNumber() {
        return orderPhoneNumber;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public BikeDTO getBikeDTO() {
        return bikeDTO;
    }

    public String getDescription() {
        return description;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public String getDiagnosticReport() {
        return diagnosticReport;
    }
}
