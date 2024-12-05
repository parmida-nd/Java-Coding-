/**
 * Abstract class Order that represents a general e-commerce order.
 * Each order has a unique ID, an order amount, and a status.
 * This class serves as a base class for different types of orders,
 * with specific rules for processing, discount, and refund policies.
 * @author Parmida Niroomand - 202313971
 */
public abstract class Order 
{
    
    // Fields
    /**
     * A unique identifier for each order.
     */
    private String orderId;
    
    /**
     * The total amount of the order in dollars.
     */
    private double orderAmount;
    
    /**
     * The current status of the order.
     * It can be one of the values in the OrderStatus enum.
     */
    private OrderStatus status;
    
    // Constructor
    /**
     * Constructs an Order with the specified ID and amount.
     * Initializes the order status to PENDING.
     *
     * @param orderId      The unique identifier for this order.
     * @param orderAmount  The total amount of the order.
     */
    public Order(String orderId, double orderAmount) 
    {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.status = OrderStatus.PENDING; // Set initial status to PENDING
    }
    
    // Abstract Method
    /**
     * Processes this order. This method is abstract, so it must
     * be implemented by subclasses to define specific processing
     * logic for each type of order.
     */
    public abstract void processOrder();
    
    // Getters and Setters
    /**
     * Retrieves the unique ID of this order.
     *
     * @return The order ID.
     */
    public String getOrderId() 
    {
        return orderId;
    }
    
    /**
     * Retrieves the total amount of this order.
     *
     * @return The order amount.
     */
    public double getOrderAmount() 
    {
        return orderAmount;
    }
    
    /**
     * Retrieves the current status of this order.
     *
     * @return The order status.
     */
    public OrderStatus getStatus() 
    {
        return status;
    }
    
    public void setOrderAmount(double orderAmount) 
    {
        this.orderAmount = orderAmount;
    }
    
    /**
     * Updates the status of this order.
     *
     * @param status The new status for the order.
     */
    public void setStatus(OrderStatus status) 
    {
        this.status = status;
    }
}