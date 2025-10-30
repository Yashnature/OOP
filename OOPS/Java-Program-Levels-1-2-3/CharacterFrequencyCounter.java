import java.util.ArrayList;
import java.util.Scanner;

public class CharacterFrequencyCounter {

    /**
     * Finds the frequency of each character in a string.
     * @param text The input string to analyze.
     * @return A 2D String array where each row contains a [character, frequency].
     */
    public static String[][] findCharFrequency(String text) {
        // 1. Create an array to store the frequency of each ASCII character.
        // The index of the array corresponds to the ASCII value of the character.
        int[] asciiFrequency = new int[256];

        // 2. Loop through the text to count each character's frequency.
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            // The char is implicitly cast to its int (ASCII) value to be used as an index.
            asciiFrequency[currentChar]++;
        }

        // Use an ArrayList to store the results, as we don't know the unique char count yet.
        ArrayList<String[]> resultList = new ArrayList<>();

        // 3. Loop through the frequency array to build the final result.
        // This loop iterates through all possible ASCII characters.
        for (int i = 0; i < asciiFrequency.length; i++) {
            // If the count for an ASCII value is greater than 0, it means it was in the string.
            if (asciiFrequency[i] > 0) {
                char character = (char) i; // Cast the index back to a char.
                int count = asciiFrequency[i];

                // Add the character and its frequency as a String array to our list.
                resultList.add(new String[]{String.valueOf(character), String.valueOf(count)});
            }
        }

        // 4. Convert the ArrayList to a 2D String array for the final return.
        return resultList.toArray(new String[0][0]);
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
            // Add special text for the space character to make it more readable.
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

        // Call the method to find the frequencies.
        String[][] frequencies = findCharFrequency(userInput);

        // Call the method to display the results.
        displayFrequencies(frequencies);

        scanner.close();
    }
}