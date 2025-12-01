import java.util.*;
public class LibraryCatalog {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
        map.put("978-111", "Java");
        map.put("978-222", "Python");
        map.put("978-333", "C++");
        System.out.println(map.getOrDefault("978-111", "Book not found"));
        map.remove("978-333");
        for (var e : map.entrySet())
            System.out.println(e.getKey()+" : "+e.getValue());
        for (var e : map.entrySet())
            if (e.getValue().equals("Python"))
                System.out.println("Found ISBN = " + e.getKey());
    }
}
