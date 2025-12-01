import java.util.Scanner;

public class CalendarPrinter {

    /**
     * The main method to drive the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for month and year.
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year (e.g., 2025): ");
        int year = scanner.nextInt();

        // Get all necessary calendar data using helper methods.
        String monthName = getMonthName(month);
        int numberOfDays = getNumberOfDaysInMonth(month, year);
        int startDay = getStartDay(month, year);

        // Display the final calendar.
        displayCalendar(monthName, year, startDay, numberOfDays);
        
        scanner.close();
    }

    /**
     * Gets the name of the month from its number.
     * @param month The month number (1-12).
     * @return The full name of the month.
     */
    public static String getMonthName(int month) {
        String[] monthNames = {"", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }

    /**
     * Gets the total number of days in a given month and year.
     * @param month The month number (1-12).
     * @param year The year.
     * @return The number of days in that month.
     */
    public static int getNumberOfDaysInMonth(int month, int year) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // Check for February in a leap year.
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month];
    }

    /**
     * Checks if a given year is a leap year.
     * @param year The year to check.
     * @return true if it is a leap year, false otherwise.
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Calculates the starting day of the week for a given month and year.
     * (0 for Sunday, 1 for Monday, ..., 6 for Saturday)
     * @param month The month number (1-12).
     * @param year The year.
     * @return The day of the week as an integer (0-6).
     */
    public static int getStartDay(int month, int year) {
        // Using the Gregorian calendar algorithm (Zeller's congruence).
        int y = year;
        int m = month;
        int d = 1; // We are finding the day for the 1st of the month.

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        return d0;
    }

    /**
     * Prints the calendar grid for a given month.
     * @param monthName The name of the month.
     * @param year The year.
     * @param startDay The starting day of the week (0-6).
     * @param numberOfDays The total days in the month.
     */
    public static void displayCalendar(String monthName, int year, int startDay, int numberOfDays) {
        System.out.println("\n      " + monthName + " " + year);
        System.out.println("---------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        // 1. Print leading spaces for the first week.
        for (int i = 0; i < startDay; i++) {
            System.out.print("    "); // 4 spaces for alignment
        }

        // 2. Print the days of the month.
        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%4d", day); // Print day, right-aligned in 4 spaces.

            // If it's Saturday, start a new line.
            if ((startDay + day) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println(); // Final new line for clean exit.
    }
}