import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PhysicalProductOrderTest.
 */
public class PhysicalProductOrderTest
{
    private PhysicalProductOrder physicalOrder;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        physicalOrder = new PhysicalProductOrder("PH123", 200.0);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        physicalOrder = null;
    }
    
    @Test
    public void testOrderInitialization() {
        assertEquals("PH123", physicalOrder.getOrderId());
        assertEquals(200.0, physicalOrder.getOrderAmount(), 0.01);
        assertEquals(OrderStatus.PENDING, physicalOrder.getStatus());
    }

    @Test
    public void testProcessOrder() {
        physicalOrder.processOrder();
        assertEquals(OrderStatus.COMPLETED, physicalOrder.getStatus());
    }

    @Test
    public void testApplyDiscountWithinLimit() {
        physicalOrder.applyDiscount(10.0);  // Applying a 10% discount
        assertEquals(180.0, physicalOrder.getOrderAmount(), 0.01);
    }

    @Test
    public void testApplyDiscountExceedingLimit() {
        physicalOrder.applyDiscount(60.0);  // Exceeds MAX_DISCOUNT_PERCENTAGE
        assertEquals(100.0, physicalOrder.getOrderAmount(), 0.01); // Discount capped at 50%
    }

    @Test
    public void testRefundEligibleWithinLimit() {
        physicalOrder.processOrder();
        assertTrue(physicalOrder.isRefundEligible(15));  // Within the 30-day limit
        physicalOrder.processRefund(15);  // Passing 15 days since purchase
        assertEquals(OrderStatus.REFUNDED, physicalOrder.getStatus());
    }

    @Test
    public void testRefundNotEligibleBeyondLimit() {
        physicalOrder.processOrder();
        assertFalse(physicalOrder.isRefundEligible(40));  // Beyond the 30-day limit
        physicalOrder.processRefund(40);  // Passing 40 days since purchase
        assertEquals(OrderStatus.COMPLETED, physicalOrder.getStatus()); // No refund should happen
    }
}