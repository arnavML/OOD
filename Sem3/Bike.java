package Sem3;

public class Bike {
    private String brand;
    private String model;
    private String serialNumber;
    private int ownerNumber;

    public Bike(String brand, String model, String serialNumber, int ownerNumber) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.ownerNumber = ownerNumber;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(int ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", ownerNumber=" + ownerNumber +
                '}';
    }
}
