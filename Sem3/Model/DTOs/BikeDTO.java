package Sem3.Model.DTOs;

public class BikeDTO {
    private String brand;
    private String model;
    private String serialNumber;
    private int ownerNumber;

    public BikeDTO(String brand, String model, String serialNumber, int ownerNumber) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.ownerNumber = ownerNumber;
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getOwnerNumber() {
        return ownerNumber;
    }
}
