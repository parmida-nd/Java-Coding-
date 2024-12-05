public interface Refundable 
{

    int MAX_REFUND_DAYS = 30;

    /**
     * Processes a refund request based on the number of days since purchase.
     *
     * @param daysSincePurchase The number of days since the purchase.
     */
    void processRefund(int daysSincePurchase);

    /**
     * Returns true if the refund request is within the allowed period of MAX_REFUND_DAYS.
     *
     * @param daysSincePurchase The number of days since the purchase.
     * @return True if the refund is eligible, otherwise false.
     */
    default boolean isRefundEligible(int daysSincePurchase) 
    {
        return daysSincePurchase <= MAX_REFUND_DAYS;
    }

    /**
     * Displays the refund policy, indicating the maximum number of days to request a refund.
     */
    static void refundPolicy() 
    {
        System.out.println("The maximum number of days to request a refund is " + MAX_REFUND_DAYS + " days.");
    }
}
