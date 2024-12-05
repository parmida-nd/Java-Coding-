import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DigitalProductOrderTest.
 */
public class DigitalProductOrderTest
{
    private DigitalProductOrder digitalOrder;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        digitalOrder = new DigitalProductOrder("DG001", 150.0);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        digitalOrder = null;
    }

    /**
     * Test initialization of the digital order.
     */
    @Test
    public void testOrderInitialization() {
        assertEquals("DG001", digitalOrder.getOrderId());
        assertEquals(150.0, digitalOrder.getOrderAmount(), 0.01);
        assertEquals(OrderStatus.PENDING, digitalOrder.getStatus());
    }

    /**
     * Test processing the digital order.
     */
    @Test
    public void testProcessOrder() {
        digitalOrder.processOrder();
        assertEquals(OrderStatus.COMPLETED, digitalOrder.getStatus());
    }

    /**
     * Test applying a discount within the maximum limit.
     */
    @Test
    public void testApplyDiscountWithinLimit() {
        digitalOrder.applyDiscount(20.0);  // Applying a 20% discount
        assertEquals(120.0, digitalOrder.getOrderAmount(), 0.01);
    }

    /**
     * Test applying a discount that exceeds the maximum limit.
     */
    @Test
    public void testApplyDiscountExceedingLimit() {
        digitalOrder.applyDiscount(60.0);  // Exceeds MAX_DISCOUNT_PERCENTAGE (should cap at 50%)
        assertEquals(75.0, digitalOrder.getOrderAmount(), 0.01); // Discount capped at 50%
    }

    /**
     * Test applying the standard discount.
     */
    @Test
    public void testApplyStandardDiscount() {
        digitalOrder.applyStandardDiscount();  // Applies a standard 5% discount
        assertEquals(142.5, digitalOrder.getOrderAmount(), 0.01);
    }
}