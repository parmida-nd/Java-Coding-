import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SubscriptionOrderTest.
 */
public class SubscriptionOrderTest
{
    private SubscriptionOrder subscriptionOrder;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        subscriptionOrder = new SubscriptionOrder("SB001", 100.0);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        subscriptionOrder = null;
    }

    /**
     * Test initialization of the subscription order.
     */
    @Test
    public void testOrderInitialization() {
        assertEquals("SB001", subscriptionOrder.getOrderId());
        assertEquals(100.0, subscriptionOrder.getOrderAmount(), 0.01);
        assertEquals(OrderStatus.PENDING, subscriptionOrder.getStatus());
    }

    /**
     * Test processing the subscription order.
     */
    @Test
    public void testProcessOrder() {
        subscriptionOrder.processOrder();
        assertEquals(OrderStatus.COMPLETED, subscriptionOrder.getStatus());
    }

    /**
     * Test applying a discount within the 10% maximum limit.
     */
    @Test
    public void testApplyDiscountWithinLimit() {
        subscriptionOrder.applyDiscount(5.0);  // Applying a 5% discount
        assertEquals(95.0, subscriptionOrder.getOrderAmount(), 0.01);
    }

    /**
     * Test applying a discount that exceeds the 10% limit.
     */
    @Test
    public void testApplyDiscountExceedingLimit() {
        subscriptionOrder.applyDiscount(15.0);  // Attempts to apply a 15% discount, should be capped at 10%
        assertEquals(90.0, subscriptionOrder.getOrderAmount(), 0.01); // Discount capped at 10%
    }
}