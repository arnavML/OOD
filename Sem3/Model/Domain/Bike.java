package Sem3.Model.Domain;

public class Bike { //Represents a bike in the system, with properties for brand, model, serial number, and owner number (which links the bike to its owner/customer in the system)
    private String brand;
    private String model;
    private String serialNumber;
    private int ownerNumber;

    public Bike(String brand, String model, String serialNumber, int ownerNumber) { //Sets the bike's brand, model, serial number, and owner number when a new bike is created
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.ownerNumber = ownerNumber;
    }

    public String getBrand() { //Returns the bike's brand
        return brand;
    }
    public void setBrand(String brand) { //Sets the bike's brand to the given value
        this.brand = brand;
    }
    public String getModel() { //Returns the bike's model
        return model;
    }

    public void setModel(String model) { //Sets the bike's model to the given value
        this.model = model;
    }

    public String getSerialNumber() { //Returns the bike's serial number
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) { //Sets the bike's serial number to the given value
        this.serialNumber = serialNumber;
    }

    public int getOwnerNumber() { //Returns the bike's owner number, which is used to link the bike to its owner (customer) in the system
        return ownerNumber;
    }

    public void setOwnerNumber(int ownerNumber) { //Sets the bike's owner number to the given value (likely redundant)
        this.ownerNumber = ownerNumber;
    }

    @Override //Didnt bother using
    public String toString() {
        return "Bike{" +
                "model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", ownerNumber=" + ownerNumber +
                '}';
    }
}
