package Sem3.Model.DTOs;

public class RepairOrderDTO {
    private int orderNumber;
    private int customerNumber;
    private String bikeSerialNumber;
    private String repairDescription;
    private double totalCost;


    
    public RepairOrderDTO(int orderNumber, int customerNumber, String bikeSerialNumber, String repairDescription, double totalCost) {
        this.orderNumber = orderNumber;
        this.customerNumber = customerNumber;
        this.bikeSerialNumber = bikeSerialNumber;
        this.repairDescription = repairDescription;
        this.totalCost = totalCost;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getBikeSerialNumber() {
        return bikeSerialNumber;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
