/**
 * Represents an order for a digital product.
 * Implements Discountable interface, but is non-refundable.
 */
public class DigitalProductOrder extends Order implements Discountable {

    /**
     * Constructor to initialize a DigitalProductOrder with a unique ID and order amount.
     *
     * @param orderId      The unique identifier for this order.
     * @param orderAmount  The total amount of the order.
     */
    public DigitalProductOrder(String orderId, double orderAmount) 
    {
        super(orderId, orderAmount);
    }

    /**
     * Processes the digital product order and sets the status to COMPLETED.
     */
    @Override
    public void processOrder() 
    {
        System.out.println("Processing digital product order for Order ID: " + getOrderId());
        setStatus(OrderStatus.COMPLETED);
    }

    /**
     * Applies a discount to the order amount, capped at MAX_DISCOUNT_PERCENTAGE.
     *
     * @param percentage The discount percentage to apply.
     */
    @Override
    public void applyDiscount(double percentage) 
    {
        if (percentage > MAX_DISCOUNT_PERCENTAGE) 
        {
            percentage = MAX_DISCOUNT_PERCENTAGE;
        }
        double discountAmount = getOrderAmount() * (percentage / 100);
        setOrderAmount(getOrderAmount() - discountAmount);
    }
}