import static java.lang.Math.*;

public class StaticImportDemo {
    public static void main(String[] args) {
        double a = 16.0;
        double b = -9.5;
        double x = 5.0, y = 3.0;

        System.out.println("Square root of " + a + " = " + sqrt(a));
        System.out.println(x + " raised to power " + y + " = " + pow(x, y));
        System.out.println("Maximum of " + a + " and " + b + " = " + max(a, b));
        System.out.println("Minimum of " + a + " and " + b + " = " + min(a, b));
        System.out.println("Absolute value of " + b + " = " + abs(b));
    }
}
