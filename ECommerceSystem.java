import java.util.ArrayList;
import java.util.List;

public class ECommerceSystem {
    public static void main(String[] args) {
        // Displaying refund and discount information using static methods
        Refundable.refundPolicy();
        Discountable.showDiscountInfo();

        // Create various orders
        List<Order> orders = new ArrayList<>();
        Order physicalOrder = new PhysicalProductOrder("PH123", 150.0);
        Order digitalOrder = new DigitalProductOrder("DG456", 80.0);
        Order subscriptionOrder = new SubscriptionOrder("SUB789", 12.0);

        // Add orders to the list
        orders.add(physicalOrder);
        orders.add(digitalOrder);
        orders.add(subscriptionOrder);

        // Processing and applying discounts/refunds
        for (Order order : orders) {
            order.processOrder();

            if (order instanceof Discountable) {
                // Apply standard discount
                ((Discountable) order).applyStandardDiscount();
            }

            if (order instanceof Refundable) {
                ((Refundable) order).processRefund(7);
            }

            System.out.println("Order ID: " + order.getOrderId() + " - Final Status: " + order.getStatus());
            System.out.println("=================================");
        }
    }
}