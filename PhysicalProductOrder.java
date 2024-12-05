/**
 * Represents an order for a physical product.
 * Implements Discountable and Refundable interfaces.
 */
public class PhysicalProductOrder extends Order implements Discountable, Refundable 
{

    /**
     * Constructor to initialize a PhysicalProductOrder with a unique ID and order amount.
     *
     * @param orderId      The unique identifier for this order.
     * @param orderAmount  The total amount of the order.
     */
    public PhysicalProductOrder(String orderId, double orderAmount) 
    {
        super(orderId, orderAmount);
    }

    /**
     * Processes the physical product order and sets the status to COMPLETED.
     */
    @Override
    public void processOrder() 
    {
        System.out.println("Processing physical product order for Order ID: " + getOrderId());
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

    /**
     * Processes a refund for the order if eligible and status is COMPLETED.
     *
     * @param daysSincePurchase The number of days since the purchase was made.
     */
    @Override
    public void processRefund(int daysSincePurchase) 
    {
        if (getStatus() == OrderStatus.COMPLETED && isRefundEligible(daysSincePurchase)) 
        {
            setStatus(OrderStatus.REFUNDED);
            System.out.println("Refund processed for Order ID: " + getOrderId());
        } 
        else 
        {
            System.out.println("Refund not eligible for Order ID: " + getOrderId());
        }
    }
}