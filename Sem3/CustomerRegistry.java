package Sem3;

public class CustomerRegistry {
    
    private java.util.List<Customer> customers;

    public CustomerRegistry() {
        this.customers = new java.util.ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomerByNumber(int number) {
        for (Customer customer : customers) {
            if (customer.getCustomerNumber() == number) {
                return customer;
            }
        }
        return null;
    }

    public java.util.List<Customer> getAllCustomers() {
        return customers;
    }

}
