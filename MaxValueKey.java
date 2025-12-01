import java.util.*;
public class MaxValueKey {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A",10,"B",20,"C",15);
        String maxKey = null;
        int max = Integer.MIN_VALUE;
        for (var e : map.entrySet())
            if (e.getValue() > max) { max = e.getValue(); maxKey = e.getKey(); }
        System.out.println("Highest value key = " + maxKey);
    }
}
