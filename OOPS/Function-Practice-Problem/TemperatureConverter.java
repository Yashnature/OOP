import java.util.*;

public class TemperatureConverter {

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static void displayResult(double original, double converted, String fromUnit, String toUnit) {
        System.out.println(original + " " + fromUnit + " = " + converted + " " + toUnit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Temperature Converter Menu:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double f = sc.nextDouble();
            double c = fahrenheitToCelsius(f);
            displayResult(f, c, "F", "C");
        } else if (choice == 2) {
            System.out.print("Enter temperature in Celsius: ");
            double c = sc.nextDouble();
            double f = celsiusToFahrenheit(c);
            displayResult(c, f, "C", "F");
        } else {
            System.out.println("Invalid choice!");
        }
    }
}
