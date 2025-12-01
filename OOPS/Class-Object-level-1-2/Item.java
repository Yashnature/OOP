import java.util.Scanner;

public class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : " + price);
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Item Code: ");
        int code = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Item Price: ");
        double price = sc.nextDouble();

        Item item = new Item(code, name, price);

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        System.out.println("\n------------------------");
        item.displayDetails();
        System.out.println("Quantity  : " + qty);
        System.out.println("Total Cost: " + item.calculateTotalCost(qty));

        sc.close();
    }
}
