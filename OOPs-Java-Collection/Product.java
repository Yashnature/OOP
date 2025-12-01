import java.util.*;

class Product {
    String name;
    double price;
    int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String toString() {
        return name + " (Price: " + price + ", Stock: " + stock + ")";
    }
}

public class InventorySystem {
    Set<String> productNames = new HashSet<>();
    List<Product> products = new ArrayList<>();
    Queue<Product> restockQueue = new LinkedList<>();
    Stack<Product> restockHistory = new Stack<>();

    public void addProduct(Product p) {
        if (!productNames.contains(p.name)) {
            productNames.add(p.name);
            products.add(p);
        }
    }

    public void checkLowStock(int threshold) {
        for (Product p : products) {
            if (p.stock < threshold) restockQueue.add(p);
        }
    }

    public void processRestock(int quantity) {
        while (!restockQueue.isEmpty()) {
            Product p = restockQueue.poll();
            p.stock += quantity;
            restockHistory.push(p);
        }
    }

    public void undoLastRestock(int quantity) {
        if (!restockHistory.isEmpty()) {
            Product p = restockHistory.pop();
            p.stock -= quantity;
        }
    }

    public void showInventory() {
        for (Product p : products) System.out.println(p);
    }

    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();

        system.addProduct(new Product("Apples", 50.0, 5));
        system.addProduct(new Product("Bananas", 30.0, 2));
        system.addProduct(new Product("Oranges", 40.0, 8));

        system.checkLowStock(5);
        system.processRestock(10);
        system.showInventory();

        System.out.println("Undoing last restock...");
        system.undoLastRestock(10);
        system.showInventory();
    }
}
