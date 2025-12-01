import java.util.Scanner;

public class UniqueCharFrequency {

    /**
     * Finds all unique characters in a string using a nested loop.
     * @param text The input string to analyze.
     * @return A char array containing only the unique characters.
     */
    public static char[] findUniqueChars(String text) {
        if (text == null || text.isEmpty()) {
            return new char[0];
        }
        
        char[] tempArray = new char[text.length()];
        int uniqueCount = 0;

        // Loop through each character of the input string.
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            boolean isDuplicate = false;

            // Check if the character has already been added to our unique list.
            for (int j = 0; j < uniqueCount; j++) {
                if (tempArray[j] == currentChar) {
                    isDuplicate = true;
                    break;
                }
            }

            // If it's not a duplicate, add it.
            if (!isDuplicate) {
                tempArray[uniqueCount++] = currentChar;
            }
        }

        // Create a final array with the exact size needed.
        char[] resultArray = new char[uniqueCount];
        System.arraycopy(tempArray, 0, resultArray, 0, uniqueCount);
        return resultArray;
    }

    /**
     * Finds the frequency of characters in a string.
     * @param text The input string to analyze.
     * @return A 2D String array where each row contains a [character, frequency].
     */
    public static String[][] findCharFrequency(String text) {
        // 1. Create and populate an ASCII frequency map for all characters.
        int[] asciiFrequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            asciiFrequency[text.charAt(i)]++;
        }

        // 2. Get the list of unique characters from the text.
        char[] uniqueChars = findUniqueChars(text);
        
        // 3. Create the final 2D array based on the number of unique characters.
        String[][] result = new String[uniqueChars.length][2];

        // 4. Loop through the unique characters and get their counts from the map.
        for (int i = 0; i < uniqueChars.length; i++) {
            char uniqueChar = uniqueChars[i];
            int frequency = asciiFrequency[uniqueChar]; // Look up the pre-counted frequency.

            result[i][0] = String.valueOf(uniqueChar);
            result[i][1] = String.valueOf(frequency);
        }
        return result;
    }

    /**
     * Displays the frequency data in a clean, tabular format.
     * @param data The 2D array containing the character and frequency info.
     */
    public static void displayFrequencies(String[][] data) {
        System.out.println("\n--- Character Frequency Report ---");
        System.out.println("--------------------------");
        System.out.printf("%-12s | %s%n", "Character", "Frequency");
        System.out.println("--------------------------");
        for (String[] row : data) {
            String character = row[0];
            if (character.equals(" ")) {
                character = "' ' (space)";
            }
            System.out.printf("%-12s | %s%n", character, row[1]);
        }
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user.
        System.out.print("Enter a string to find character frequencies: ");
        String userInput = scanner.nextLine();

        // Call the main method to find the frequencies.
        String[][] frequencies = findCharFrequency(userInput);

        // Call the display method to show the results.
        displayFrequencies(frequencies);

        scanner.close();
    }
}