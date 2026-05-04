package Sem3;

public class Customer {
    
    private String name;
    private int customerNumber;
    private String email;
    private Bike bike;

    public Customer(String name, int customerNumber, String email, Bike bike) {
        this.name = name;
        this.customerNumber = customerNumber;
        this.email = email;
        this.bike = bike;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", email='" + email + '\'' +
                ", bike=" + bike +
                '}';
    }

}
