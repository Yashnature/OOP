import java.util.Random;

public class StudentGrader {

    /**
     * Generates random 2-digit scores for a given number of students in 3 subjects.
     * @param numStudents The number of students in the class.
     * @return A 2D int array where each row is [Physics, Chemistry, Math] score.
     */
    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        Random random = new Random();
        // We'll generate scores between 35 and 100 for a more realistic grade distribution.
        int minScore = 35;
        int maxScore = 100;

        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = random.nextInt(maxScore - minScore + 1) + minScore; // Physics
            scores[i][1] = random.nextInt(maxScore - minScore + 1) + minScore; // Chemistry
            scores[i][2] = random.nextInt(maxScore - minScore + 1) + minScore; // Math
        }
        return scores;
    }

    /**
     * Calculates the total, average, and percentage for each student.
     * @param scores The 2D array of student scores.
     * @return A 2D double array where each row is [Total, Average, Percentage].
     */
    public static double[][] calculateMetrics(int[][] scores) {
        double[][] metrics = new double[scores.length][3];
        final double MAX_TOTAL_MARKS = 300.0;

        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double percentage = (total / MAX_TOTAL_MARKS) * 100;

            // Round the percentage to two decimal places.
            double roundedPercentage = Math.round(percentage * 100.0) / 100.0;

            metrics[i][0] = total;
            metrics[i][1] = roundedPercentage; // Average is same as percentage
            metrics[i][2] = roundedPercentage;
        }
        return metrics;
    }

    /**
     * Assigns a grade to each student based on their percentage.
     * @param metrics The 2D array containing student metrics.
     * @return A 1D String array containing the grade for each student.
     */
    public static String[] calculateGrades(double[][] metrics) {
        String[] grades = new String[metrics.length];
        for (int i = 0; i < metrics.length; i++) {
            double percentage = metrics[i][2];
            if (percentage >= 90) {
                grades[i] = "A";
            } else if (percentage >= 80) {
                grades[i] = "B";
            } else if (percentage >= 70) {
                grades[i] = "C";
            } else if (percentage >= 60) {
                grades[i] = "D";
            } else {
                grades[i] = "E";
            }
        }
        return grades;
    }

    /**
     * Displays the complete student scorecard in a formatted table.
     * @param scores The original scores array.
     * @param metrics The calculated metrics array.
     * @param grades The calculated grades array.
     */
    public static void displayScorecard(int[][] scores, double[][] metrics, String[] grades) {
        System.out.println("--- Student Scorecard ---");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-12s | %-10s | %-12s | %-8s | %-8s | %-12s | %-8s%n",
                "Student #", "Physics", "Chemistry", "Maths", "Total", "Percentage", "Grade");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-12s | %-10d | %-12d | %-8d | %-8.0f | %-12.2f%% | %-8s%n",
                    "Student " + (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    metrics[i][0], metrics[i][2], grades[i]);
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        final int NUMBER_OF_STUDENTS = 10;

        // 1. Generate random scores.
        int[][] scores = generateScores(NUMBER_OF_STUDENTS);

        // 2. Calculate total, average, and percentage.
        double[][] metrics = calculateMetrics(scores);

        // 3. Determine the grade for each student.
        String[] grades = calculateGrades(metrics);

        // 4. Display the final, formatted scorecard.
        displayScorecard(scores, metrics, grades);
    }
}