package Sem3;

public class CustomerRegistry { //The CustomerRegistry class is responsible for managing a collection of customers in the system. It provides methods for adding customers, finding customers by their unique customer number, and retrieving a list of all customers.
    
    private java.util.List<Customer> customers;

    public CustomerRegistry() { //Initializes the customer registry with an empty list of customers
        this.customers = new java.util.ArrayList<>();
    }

    public void addCustomer(Customer customer) { //Adds a new customer to the registry by adding them to the list of customers
        customers.add(customer);
    }

    public Customer findCustomerByNumber(int number) { //Searches through the list of customers to find a customer with a matching customer number. If found, it returns the customer; if not, it returns null.
        for (Customer customer : customers) {
            if (customer.getCustomerNumber() == number) {
                return customer;
            }
        }
        return null;
    }

    public java.util.List<Customer> getAllCustomers() { //Returns a list of all customers in the registry
        return customers;
    }

}
