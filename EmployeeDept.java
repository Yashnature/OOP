import java.util.*;
public class EmployeeDept {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(101, "HR");
        map.put(102, "IT");
        map.put(103, "Finance");
        map.put(104, "HR");
        map.put(103, "IT");
        System.out.println("Employees in IT:");
        for (var e : map.entrySet())
            if (e.getValue().equals("IT"))
                System.out.println(e.getKey());
        Map<String, Integer> count = new HashMap<>();
        for (String dept : map.values())
            count.put(dept, count.getOrDefault(dept, 0) + 1);
        System.out.println(count);
    }
}
