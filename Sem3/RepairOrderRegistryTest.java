package Sem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RepairOrderRegistryTest {

    private RepairOrderRegistry registry;
    private RepairOrder testOrder;

    // This runs before EVERY test, ensuring a completely clean slate.
    @Before
    public void setUp() {
        registry = new RepairOrderRegistry();
        testOrder = new RepairOrder(708123456, "Routine maintenance", "2024-06-01", "Pending");
    }

    @Test
    public void testAddRepairOrder() {
        // Arrange is handled by setUp()
        
        // Act
        registry.addRepairOrder(testOrder);
        
        // Assert: Prove the list now contains exactly 1 repair order
        assertEquals("Registry should contain 1 repair order after adding.", 1, registry.getAllRepairOrders().size());
    }

    @Test
    public void testFindRepairOrderByNumber_Success() {
        // Arrange
        registry.addRepairOrder(testOrder);
        
        // Act: Try to find the repair order we just added
        RepairOrder foundOrder = registry.findRepairOrderCustomerByNumber(708123456);
        
        // Assert: Prove we got the right repair order back
        assertNotNull("The returned repair order should not be null.", foundOrder);
        assertEquals("The description of the found repair order should match.", "Routine maintenance", foundOrder.getDescription());
    }

    @Test
    public void testFindRepairOrderByNumber_NotFound() {
        // Arrange: We add a repair order with number 708123456
        registry.addRepairOrder(testOrder);
        
        // Act: Try to search for a completely different number
        RepairOrder foundOrder = registry.findRepairOrderCustomerByNumber(999999999);
        
        // Assert: Prove the system correctly returns null when it can't find a match
        assertNull("Searching for a non-existent number should return null.", foundOrder);
    }
}
