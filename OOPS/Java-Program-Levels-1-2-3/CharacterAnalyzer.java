import java.util.Scanner;

public class CharacterAnalyzer {

    /**
     * Checks if a character is a vowel, consonant, or neither.
     * This is a helper method for the main analysis function.
     *
     * @param c The character to check.
     * @return A String: "Vowel", "Consonant", or "Not a Letter".
     */
    public static String checkCharType(char c) {
        // Convert to lowercase for simplified checking.
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32);
        }

        // Check against the five vowels.
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return "Vowel";
        }
        // Check if it's in the alphabet range (and not a vowel).
        else if (c >= 'a' && c <= 'z') {
            return "Consonant";
        }
        // If none of the above, it's a symbol, number, or space.
        else {
            return "Not a Letter";
        }
    }

    /**
     * Analyzes a string and classifies each character.
     *
     * @param text The input string to analyze.
     * @return A 2D String array where each row contains a character and its type.
     */
    public static String[][] analyzeString(String text) {
        // Create a 2D array with a row for each character.
        String[][] analysisResult = new String[text.length()][2];

        // Iterate through the string to analyze each character.
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            // Column 0: The character itself (converted to a String).
            analysisResult[i][0] = String.valueOf(currentChar);
            // Column 1: The type of the character.
            analysisResult[i][1] = checkCharType(currentChar);
        }
        return analysisResult;
    }

    /**
     * Displays the 2D array of analysis results in a formatted table.
     *
     * @param data The 2D array containing character and type information.
     */
    public static void displayResults(String[][] data) {
        if (data.length == 0) {
            System.out.println("The input string is empty.");
            return;
        }

        System.out.println("\n--- Character Analysis Breakdown ---");
        System.out.println("----------------------------");
        System.out.printf("%-12s | %s%n", "Character", "Type");
        System.out.println("----------------------------");

        // Loop through the data and print each row.
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-12s | %s%n", "'" + data[i][0] + "'", data[i][1]);
        }
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Take user input.
        System.out.print("Enter a line of text for analysis: ");
        String userInput = scanner.nextLine();

        // 2. Analyze the string to get the 2D data array.
        String[][] analysisData = analyzeString(userInput);

        // 3. Call the dedicated method to display the results.
        displayResults(analysisData);

        scanner.close();
    }
}