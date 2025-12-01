import java.util.*;
public class StudentGrades {
    public static void main(String[] args) {
        Map<String, Double> grades = new TreeMap<>();
        grades.put("Aman", 85.0);
        grades.put("Riya", 92.0);
        grades.put("Sam", 78.0);
        grades.put("Aman", 90.0);
        grades.remove("Sam");
        for (var e : grades.entrySet())
            System.out.println(e.getKey() + " = " + e.getValue());
    }
}
