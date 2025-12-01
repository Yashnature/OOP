import java.util.*;

public class UnitConverterDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter kilometers: ");
        double km = sc.nextDouble();
        System.out.print("Enter kilograms: ");
        double kg = sc.nextDouble();

        System.out.println(km + " km = " + ConversionUtils.kmToMiles(km) + " miles");
        System.out.println(kg + " kg = " + ConversionUtils.kgToLbs(kg) + " lbs");

        sc.close();
    }
}

interface ConversionUtils {
    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    static double kgToLbs(double kg) {
        return kg * 2.20462;
    }
}
