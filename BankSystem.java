import java.util.*;
public class BankSystem {
    public static void main(String[] args) {
        Map<String, Double> accounts = new HashMap<>();
        accounts.put("AC001", 5000.0);
        accounts.put("AC002", 8000.0);
        accounts.put("AC003", 12000.0);
        accounts.put("AC004", 3000.0);
        accounts.put("AC001", accounts.get("AC001") + 2000);
        double withdraw = 5000;
        if (accounts.get("AC004") >= withdraw)
            accounts.put("AC004", accounts.get("AC004") - withdraw);
        else
            System.out.println("Insufficient funds for AC004");
        List<Map.Entry<String, Double>> list = new ArrayList<>(accounts.entrySet());
        list.sort((a,b) -> Double.compare(b.getValue(), a.getValue()));
        for (var e : list)
            System.out.println(e.getKey() + " = " + e.getValue());
        System.out.println("Top 3:");
        for (int i = 0; i < Math.min(3, list.size()); i++)
            System.out.println(list.get(i).getKey());
    }
}
