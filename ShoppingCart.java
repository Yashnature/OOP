import java.util.*;
public class ShoppingCart {
    public static void main(String[] args) {
        LinkedHashMap<String, Double> cart = new LinkedHashMap<>();
        cart.put("Laptop", 40000.0);
        cart.put("Mouse", 500.0);
        cart.put("Keyboard", 1500.0);
        for (var e : cart.entrySet())
            System.out.println(e.getKey() + " - " + e.getValue());
        double total = 0;
        for (double p : cart.values()) total += p;
        if (total > 5000) total *= 0.90;
        System.out.println("Total bill = " + total);
        cart.remove("Mouse");
        System.out.println("After removal: " + cart);
    }
}
