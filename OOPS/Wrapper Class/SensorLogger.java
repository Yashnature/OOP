public class SensorLogger {

    public static void logTemperature(Double temp) {
        if (temp == null) {
            System.out.println("No temperature data available");
        } else {
            System.out.println("Logged temperature: " + temp);
        }
    }

    public static void main(String[] args) {
        double primitiveTemp = 36.6;
        Double wrapperTemp = 37.2;
        Double nullTemp = null;

        logTemperature(primitiveTemp);
        logTemperature(wrapperTemp);
        logTemperature(nullTemp);
    }
}
