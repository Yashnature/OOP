interface UnitConverter {
    static double kmToMiles(double km) {
        return km * 0.621371;
    }
    static double kgToLbs(double kg) {
        return kg * 2.20462;
    }
}

class LogisticsTool {
    public static void main(String[] args) {
        double distanceKm = 10;
        double weightKg = 50;

        double distanceMiles = UnitConverter.kmToMiles(distanceKm);
        double weightLbs = UnitConverter.kgToLbs(weightKg);

        System.out.println(distanceKm + " km = " + distanceMiles + " miles");
        System.out.println(weightKg + " kg = " + weightLbs + " lbs");
    }
}
