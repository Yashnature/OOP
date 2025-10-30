import java.util.ArrayList;
import java.util.Scanner;

public class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return price * quantity;
    }
}

class ShoppingCart {
    ArrayList<CartItem> cart = new ArrayList<>();

    void addItem(String itemName, double price, int quantity) {
        cart.add(new CartItem(itemName, price, quantity));
        System.out.println(quantity + " x " + itemName + " added to the cart.");
    }

    void removeItem(String itemName) {
        boolean removed = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).itemName.equalsIgnoreCase(itemName)) {
                cart.remove(i);
                System.out.println(itemName + " removed from the cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Item not found in cart.");
        }
    }

    void displayTotalCost() {
        double total = 0;
        System.out.println("\n--- Cart Details ---");
        for (CartItem item : cart) {
            System.out.println(item.itemName + " | Price: " + item.price + " | Qty: " + item.quantity + " | Subtotal: " + item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.println("Total Cost: " + total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        int choice;
        do {
            System.out.println("\n--- Shopping Cart Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Cart & Total Cost");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    cart.addItem(name, price, qty);
                    break;

                case 2:
                    System.out.print("Enter Item Name to Remove: ");
                    String removeName = sc.nextLine();
                    cart.removeItem(removeName);
                    break;

                case 3:
                    cart.displayTotalCost();
                    break;

                case 4:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
