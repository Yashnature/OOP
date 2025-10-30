import java.util.Scanner;

public class BMICalculator {

    /**
     * Calculates the BMI and determines the corresponding health status for one person.
     * This is a helper method.
     * @param weightKg The person's weight in kilograms.
     * @param heightCm The person's height in centimeters.
     * @return A String array containing the calculated [BMI, Status].
     */
    public static String[] calculateBmiAndStatus(double weightKg, double heightCm) {
        if (heightCm <= 0 || weightKg <= 0) {
            return new String[]{"0.0", "Invalid Input"};
        }

        // Convert height from cm to meters for the BMI formula.
        double heightM = heightCm / 100.0;
        // Calculate BMI using the formula: weight / (height * height).
        double bmi = weightKg / (heightM * heightM);
        // Round BMI to one decimal place for readability.
        double roundedBmi = Math.round(bmi * 10.0) / 10.0;

        String status;
        if (roundedBmi < 18.5) {
            status = "Underweight";
        } else if (roundedBmi < 25) {
            status = "Normal weight";
        } else if (roundedBmi < 30) {
            status = "Overweight";
        } else {
            status = "Obesity";
        }

        return new String[]{String.valueOf(roundedBmi), status};
    }

    /**
     * Processes the entire team's data, calling the helper method for each person.
     * @param measurements A 2D array containing [weight, height] for each person.
     * @return A 2D String array with [Weight, Height, BMI, Status] for display.
     */
    public static String[][] processAllMembers(double[][] measurements) {
        String[][] reportData = new String[measurements.length][4];

        for (int i = 0; i < measurements.length; i++) {
            double weight = measurements[i][0];
            double height = measurements[i][1];

            // Call the helper to get BMI and Status.
            String[] bmiInfo = calculateBmiAndStatus(weight, height);

            // Populate the final report array with all data as strings.
            reportData[i][0] = String.valueOf(weight);
            reportData[i][1] = String.valueOf(height);
            reportData[i][2] = bmiInfo[0]; // Calculated BMI
            reportData[i][3] = bmiInfo[1]; // Calculated Status
        }
        return reportData;
    }

    /**
     * Displays the final BMI report in a clean, tabular format.
     * @param reportData The fully processed 2D String array.
     */
    public static void displayBmiReport(String[][] reportData) {
        System.out.println("\n--- Team BMI Report ---");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-15s%n",
                "Person #", "Weight (kg)", "Height (cm)", "BMI", "Status");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < reportData.length; i++) {
            System.out.printf("%-10s | %-12s | %-12s | %-8s | %-15s%n",
                    (i + 1), reportData[i][0], reportData[i][1], reportData[i][2], reportData[i][3]);
        }
        System.out.println("------------------------------------------------------------------");
    }


    public static void main(String[] args) {
        final int TEAM_SIZE = 10;
        double[][] measurements = new double[TEAM_SIZE][2];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the Weight (kg) and Height (cm) for each of the " + TEAM_SIZE + " team members.");

        // 1. Take user input for each person.
        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.printf("\nEnter details for Person %d:%n", i + 1);
            System.out.print("  Weight (kg): ");
            measurements[i][0] = scanner.nextDouble(); // Column 0 for Weight
            System.out.print("  Height (cm): ");
            measurements[i][1] = scanner.nextDouble(); // Column 1 for Height
        }

        // 2. Process the raw data to calculate BMI and status.
        String[][] bmiReport = processAllMembers(measurements);

        // 3. Display the final, formatted report.
        displayBmiReport(bmiReport);

        scanner.close();
    }
}