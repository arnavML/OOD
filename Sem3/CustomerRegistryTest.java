package Sem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerRegistryTest {

    private CustomerRegistry registry;
    private Customer testCustomer;
    private Bike testBike;

    // This runs before EVERY test, ensuring a completely clean slate.
    @Before
    public void setUp() {
        registry = new CustomerRegistry();
        testBike = new Bike("Crescent", "Classic", "CR1001", 708123456);
        testCustomer = new Customer("Astrid Lindgren", 708123456, "astrid.l@example.se", testBike);
    }

    @Test
    public void testAddCustomer() {
        // Arrange is handled by setUp()
        
        // Act
        registry.addCustomer(testCustomer);
        
        // Assert: Prove the list now contains exactly 1 customer
        assertEquals("Registry should contain 1 customer after adding.", 1, registry.getAllCustomers().size());
    }

    @Test
    public void testFindCustomerByNumber_Success() {
        // Arrange
        registry.addCustomer(testCustomer);
        
        // Act: Try to find the customer we just added
        Customer foundCustomer = registry.findCustomerByNumber(708123456);
        
        // Assert: Prove we got the right customer back
        assertNotNull("The returned customer should not be null.", foundCustomer);
        assertEquals("The name of the found customer should match.", "Astrid Lindgren", foundCustomer.getName());
    }

    @Test
    public void testFindCustomerByNumber_NotFound() {
        // Arrange: We add a customer with number 708123456
        registry.addCustomer(testCustomer);
        
        // Act: Try to search for a completely different number
        Customer foundCustomer = registry.findCustomerByNumber(999999999);
        
        // Assert: Prove the system correctly returns null when it can't find a match
        assertNull("Searching for a non-existent number should return null.", foundCustomer);
    }
}