public class Inventery_items {
    public static void main(String[] args) {
        int itemCode = 101;
        String itemName = "Notebook";
        double price = 49.9;
        int quantity = 3;
        double totalCost = price * quantity;

        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Unit: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + totalCost);
    }
}
