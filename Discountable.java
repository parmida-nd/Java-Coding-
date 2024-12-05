public interface Discountable {

    double MAX_DISCOUNT_PERCENTAGE = 50.0;

    /**
     * Applies a discount to the given amount based on the percentage.
     *
     * @param percentage The discount percentage to apply.
     */
    void applyDiscount(double percentage);

    /**
     * Applies a standard 5% discount by calling applyDiscount(5.0).
     */
    default void applyStandardDiscount() {
        applyDiscount(5.0);
    }

    /**
     * Displays information about the maximum discount allowed.
     */
    static void showDiscountInfo() {
        System.out.println("The maximum discount allowed is " + MAX_DISCOUNT_PERCENTAGE + "%.");
    }

    /**
     * Calculates the total discount based on the amount and quantity of items ordered.
     *
     * @param amount The price of a single item.
     * @param quantity The quantity of items ordered.
     * @return The total discount amount.
     */
    static double calculateTotalDiscount(double amount, int quantity) {
        double totalDiscount = amount * quantity * (MAX_DISCOUNT_PERCENTAGE / 100);
        return totalDiscount;
    }
}
