import java.util.*;

public class EmployeeNameDemo {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("Alice", "Bob", "Charlie");

        System.out.println("Employee Names in Uppercase:");
        employees.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
