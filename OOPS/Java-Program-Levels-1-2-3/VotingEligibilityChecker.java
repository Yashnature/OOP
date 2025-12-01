import java.util.Random;

public class VotingEligibilityChecker {

    /**
     * Generates an array of random 2-digit ages for a given number of students.
     * @param studentCount The number of student ages to generate.
     * @return A 1D int array containing the ages.
     */
    public static int[] generateAges(int studentCount) {
        Random random = new Random();
        int[] ages = new int[studentCount];
        // The range for 2-digit ages is 10 to 99.
        int minAge = 10;
        int maxAge = 99;

        for (int i = 0; i < studentCount; i++) {
            // Formula to generate a random number in a range [min, max]
            ages[i] = random.nextInt(maxAge - minAge + 1) + minAge;
        }
        return ages;
    }

    /**
     * Checks the voting eligibility for each age in an array.
     * @param ages A 1D int array of student ages.
     * @return A 2D String array where each row contains [age, eligibility].
     */
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] eligibilityData = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            boolean canVote;

            // Validate age and determine eligibility.
            // Note: Negative age check is included as good practice, though our
            // random generator won't produce negative numbers.
            if (age < 18) {
                canVote = false;
            } else {
                canVote = true;
            }

            // Store the age and the boolean result as strings in the 2D array.
            eligibilityData[i][0] = String.valueOf(age);
            eligibilityData[i][1] = String.valueOf(canVote);
        }
        return eligibilityData;
    }

    /**
     * Displays the 2D array of eligibility data in a formatted table.
     * @param data The 2D array containing age and eligibility status.
     */
    public static void displayResults(String[][] data) {
        System.out.println("--- Student Voting Eligibility ---");
        System.out.println("--------------------------");
        System.out.printf("%-10s | %s%n", "Age", "Can Vote?");
        System.out.println("--------------------------");

        // Loop through the data and print each student's result.
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10s | %s%n", data[i][0], data[i][1]);
        }
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        // Define the number of students in the class.
        final int NUMBER_OF_STUDENTS = 10;

        // 1. Generate random ages for the students.
        int[] studentAges = generateAges(NUMBER_OF_STUDENTS);

        // 2. Check the eligibility for each generated age.
        String[][] eligibilityData = checkVotingEligibility(studentAges);

        // 3. Display the final results in a table.
        displayResults(eligibilityData);
    }
}