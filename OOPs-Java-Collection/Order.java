import java.util.*;

class Order {
    int orderId;
    String customerName;
    double amount;

    Order(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order)) return false;
        Order o = (Order) obj;
        return this.orderId == o.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId + ", Customer: " + customerName + ", Amount: " + amount;
    }
}

public class ECommerceOrderProcessing {
    public static void main(String[] args) {
        List<Order> allOrders = new ArrayList<>();
        allOrders.add(new Order(101, "Alice", 5000));
        allOrders.add(new Order(102, "Bob", 2500));
        allOrders.add(new Order(101, "Alice", 5000));
        allOrders.add(new Order(103, "Charlie", 3000));
        allOrders.add(new Order(104, "David", 4500));

        System.out.println("All Orders (with duplicates):");
        allOrders.forEach(System.out::println);

        Set<Order> uniqueOrders = new LinkedHashSet<>(allOrders);
        System.out.println("\nAfter Removing Duplicates:");
        uniqueOrders.forEach(System.out::println);

        Queue<Order> orderQueue = new LinkedList<>(uniqueOrders);
        Stack<Order> failedOrders = new Stack<>();

        System.out.println("\nProcessing Orders:");
        while (!orderQueue.isEmpty()) {
            Order current = orderQueue.poll();
            System.out.println("Processing " + current);
            if (current.orderId % 2 == 0) {
                System.out.println("❌ Order failed: " + current.orderId);
                failedOrders.push(current);
            } else {
                System.out.println("✅ Order processed successfully: " + current.orderId);
            }
        }

        System.out.println("\nReprocessing Failed Orders:");
        while (!failedOrders.isEmpty()) {
            Order failed = failedOrders.pop();
            System.out.println("Retrying " + failed);
            System.out.println("✅ Retried successfully: " + failed.orderId);
        }
    }
}
