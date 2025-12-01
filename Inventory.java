import java.util.*;
public class Inventory {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();
        stock.put("Milk", 10);
        stock.put("Bread", 5);
        stock.put("Rice", 20);
        stock.put("Milk", stock.get("Milk") - 3);
        stock.put("Bread", stock.get("Bread") - 5);
        if (stock.get("Bread") <= 0) stock.remove("Bread");
        stock.put("Rice", stock.get("Rice") + 10);
        System.out.println("Milk left = " + stock.getOrDefault("Milk",0));
        System.out.println("Out of stock:");
        for (var e : stock.entrySet())
            if (e.getValue() == 0) System.out.println(e.getKey());
    }
}
