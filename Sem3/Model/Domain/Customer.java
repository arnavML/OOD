package Sem3.model.domain;

public class Customer { //Represents a customer in the system, with properties for name, customer number, email, and bike (which links the customer to their bike in the system)
    
    private String name;
    private int customerNumber;
    private String email;
    private Bike bike;

    public Customer(String name, int customerNumber, String email, Bike bike) { //Sets the customer's name, customer number, email, and bike when a new customer is created
        this.name = name;
        this.customerNumber = customerNumber;
        this.email = email;
        this.bike = bike;
    }

    public String getName() { //Returns the customer's name
        return name;
    }

    public void setName(String name) {  //Sets the customer's name to the given value
        this.name = name;
    }

    public int getCustomerNumber() { //Returns the customer's unique customer number, which is used to link the customer to their bike and repair orders in the system
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) { //Sets the customer's unique customer number to the given value (likely redundant)
        this.customerNumber = customerNumber;
    }

    public String getEmail() { //Returns the customer's email
        return email;
    }

    public void setEmail(String email) { //Sets the customer's email to the given value
        this.email = email;
    }

    public Bike getBike() { //Returns the customer's bike
        return bike;
    }

    public void setBike(Bike bike) { //Sets the customer's bike
        this.bike = bike;
    }

}
