public class ShoppingCart {
    public static void main(String[] args) {
        String[] priceStrings = {"250", "499", "99", "abc", "150"};
        int total = 0;
        System.out.println("Calculating total price...");
        for (String price : priceStrings) {
            try {
                int value = Integer.parseInt(price);
                total += value;
                System.out.println("Added: " + value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price: " + price + " (skipped)");
            }
        }
        System.out.println("--------------------------");
        System.out.println("Total Price = " + total);
    }
}
