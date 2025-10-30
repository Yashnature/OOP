import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first date (dd-MM-yyyy): ");
        String date1Str = sc.nextLine();
        System.out.print("Enter second date (dd-MM-yyyy): ");
        String date2Str = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date1 = LocalDate.parse(date1Str, formatter);
        LocalDate date2 = LocalDate.parse(date2Str, formatter);

        if (date1.isBefore(date2)) {
            System.out.println(date1.format(formatter) + " is before " + date2.format(formatter));
        } else if (date1.isAfter(date2)) {
            System.out.println(date1.format(formatter) + " is after " + date2.format(formatter));
        } else if (date1.isEqual(date2)) {
            System.out.println(date1.format(formatter) + " is the same as " + date2.format(formatter));
        }
    }
}
