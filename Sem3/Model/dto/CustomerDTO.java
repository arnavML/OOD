package Sem3.model.dto;

public class CustomerDTO {
        
    private String name;
    private int customerNumber;
    private String email;
    private BikeDTO bikedDTO;

    public CustomerDTO(String name, int customerNumber, String email, BikeDTO bikeDTO) { //Sets the customer's name, customer number, email, and bike when a new customer is created
        this.name = name;
        this.customerNumber = customerNumber;
        this.email = email;
        this.bikedDTO = bikeDTO;
    }

    public String getName() { //Returns the customer's name
        return name;
    }
    public int getCustomerNumber() { //Returns the customer's unique customer number, which is used to link the customer to their bike and repair orders in the system
        return customerNumber;
    }
    public String getEmail() { //Returns the customer's email
        return email;
    }
    public BikeDTO getBike() { //Returns the customer's bike
        return bikedDTO;
    }
}
