import java.util.function.Predicate;

class TemperatureAlertSystem {
    public static void main(String[] args) {
        Predicate<Double> highTemperature = temp -> temp > 37.5;

        double[] readings = {36.6, 37.0, 38.2, 36.9, 39.1};

        for (double temp : readings) {
            if (highTemperature.test(temp)) {
                System.out.println("Alert! High temperature detected: " + temp + "°C");
            } else {
                System.out.println("Temperature normal: " + temp + "°C");
            }
        }
    }
}
