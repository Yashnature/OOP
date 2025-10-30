import java.util.*;

public class ECommercePlatform {
    public static void main(String[] args) {
        class Product {
            String name;
            double price;

            Product(String name, double price) {
                this.name = name;
                this.price = price;
            }
        }

        class Order {
            int orderId;
            ArrayList<Product> products = new ArrayList<>();

            Order(int orderId) {
                this.orderId = orderId;
            }

            void addProduct(Product p) {
                products.add(p);
            }

            void showOrder() {
                System.out.println("Order ID: " + orderId);
                for (Product p : products) {
                    System.out.println(" Product: " + p.name + " | Price: ₹" + p.price);
                }
            }
        }

        class Customer {
            String name;
            ArrayList<Order> orders = new ArrayList<>();

            Customer(String name) {
                this.name = name;
            }

            void placeOrder(Order o) {
                orders.add(o);
                System.out.println(name + " placed Order ID: " + o.orderId);
            }

            void showOrders() {
                System.out.println("\nOrders for " + name + ":");
                for (Order o : orders) {
                    o.showOrder();
                }
            }
        }

        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Smartphone", 20000);
        Product p3 = new Product("Headphones", 2000);

        Order o1 = new Order(101);
        o1.addProduct(p1);
        o1.addProduct(p3);

        Order o2 = new Order(102);
        o2.addProduct(p2);

        Customer c1 = new Customer("Raghuraj");
        Customer c2 = new Customer("Ananya");

        c1.placeOrder(o1);
        c2.placeOrder(o2);

        c1.showOrders();
        c2.showOrders();
    }
}
