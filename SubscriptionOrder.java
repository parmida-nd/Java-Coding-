/**
 * Represents an order for a subscription service.
 * Implements Discountable interface with a custom discount logic and is non-refundable.
 */
public class SubscriptionOrder extends Order implements Discountable 
{

    /**
     * Constructor to initialize a SubscriptionOrder with a unique ID and order amount.
     *
     * @param orderId      The unique identifier for this order.
     * @param orderAmount  The total amount of the order.
     */
    public SubscriptionOrder(String orderId, double orderAmount) 
    {
        super(orderId, orderAmount);
    }

    /**
     * Processes the subscription order and sets the status to COMPLETED.
     */
    @Override
    public void processOrder() 
    {
        System.out.println("Processing subscription order for Order ID: " + getOrderId());
        setStatus(OrderStatus.COMPLETED);
    }

    /**
     * Applies a discount with a maximum of 10%, specific to subscriptions.
     *
     * @param percentage The discount percentage to apply.
     */
    @Override
    public void applyDiscount(double percentage) 
    {
        if (percentage > 10.0) 
        {
            percentage = 10.0;  // Max discount for subscriptions is 10%
        }
        double discountAmount = getOrderAmount() * (percentage / 100);
        setOrderAmount(getOrderAmount() - discountAmount);
    }
}