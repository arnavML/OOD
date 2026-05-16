package Sem3.model.dto;

public class CustomerDTO {
        
    private String name;
    private int customerNumber;
    private String email;
    private BikeDTO bikeDTO;

    public CustomerDTO(String name, int customerNumber, String email, BikeDTO bikeDTO) { //Sets the customer's name, customer number, email, and bike when a new customer is created
        this.name = name;
        this.customerNumber = customerNumber;
        this.email = email;
        this.bikeDTO = bikeDTO;
    }

    public String getName() { return name; }
    public int getCustomerNumber() { return customerNumber; }
    public String getEmail() { return email; }
    public BikeDTO getBike() { return bikeDTO; }
}
