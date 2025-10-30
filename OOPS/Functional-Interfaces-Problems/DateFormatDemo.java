import java.util.*;
import java.text.*;

public class DateFormatDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        System.out.println("Formatted (dd/MM/yyyy): " + DateUtils.formatDate(input, "dd/MM/yyyy"));
        System.out.println("Formatted (MMMM dd, yyyy): " + DateUtils.formatDate(input, "MMMM dd, yyyy"));
        System.out.println("Formatted (MM-dd-yyyy): " + DateUtils.formatDate(input, "MM-dd-yyyy"));

        sc.close();
    }
}

interface DateUtils {
    static String formatDate(String dateStr, String format) {
        try {
            SimpleDateFormat original = new SimpleDateFormat("yyyy-MM-dd");
            Date date = original.parse(dateStr);
            SimpleDateFormat target = new SimpleDateFormat(format);
            return target.format(date);
        } catch (ParseException e) {
            return "Invalid date";
        }
    }
}
