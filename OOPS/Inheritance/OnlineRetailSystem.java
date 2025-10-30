import java.util.*;  

class Order {
    String orderId;
    String orderDate;

    void getOrderStatus() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: Order Placed");
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    void getOrderStatus() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Status: Shipped");
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    void getOrderStatus() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Status: Delivered");
    }
}

public class OnlineRetailSystem {
    public static void main(String[] args) {
        Order o = new Order();
        o.orderId = "ORD1001";
        o.orderDate = "2025-10-13";

        ShippedOrder s = new ShippedOrder();
        s.orderId = "ORD1002";
        s.orderDate = "2025-10-12";
        s.trackingNumber = "TRK12345";

        DeliveredOrder d = new DeliveredOrder();
        d.orderId = "ORD1003";
        d.orderDate = "2025-10-10";
        d.trackingNumber = "TRK54321";
        d.deliveryDate = "2025-10-13";

        o.getOrderStatus();
        System.out.println();
        s.getOrderStatus();
        System.out.println();
        d.getOrderStatus();
    }
}
