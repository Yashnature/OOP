import java.util.*;

public class Product {
    private static double discount = 0.0;

    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }

    public void displayDetails() {
        System.out.println("Product: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000, 2);
        Product p2 = new Product("Phone", 20000, 3);

        p1.displayDetails();
        p2.displayDetails();

        Product.updateDiscount(10);

        p1.displayDetails();
        p2.displayDetails();
    }
}
