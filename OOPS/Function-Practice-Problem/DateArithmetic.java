import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (dd-MM-yyyy): ");
        String inputDate = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(inputDate, formatter);

        LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);

        System.out.println("Original Date: " + date.format(formatter));
        System.out.println("After Adding 7 days, 1 month, 2 years and subtracting 3 weeks: " + result.format(formatter));
    }
}
