import java.util.ArrayList;
import java.util.Scanner;

public class NestedLoopFrequency {

    /**
     * Finds the frequency of each character in a string using a nested loop.
     * @param text The input string to analyze.
     * @return A 1D String array where each element describes a character and its frequency.
     */
    public static String[] findCharFrequency(String text) {
        // Create a character array and a corresponding frequency array.
        char[] chars = text.toCharArray();
        int[] frequency = new int[chars.length];

        // --- Nested Loop to Find Frequencies ---
        // The outer loop picks a character.
        for (int i = 0; i < chars.length; i++) {
            // Use the null character '\0' as a marker for already-counted characters.
            if (chars[i] == '\0') {
                continue; // Skip characters that have already been counted.
            }

            // Initialize the frequency for the current character to 1.
            frequency[i] = 1;

            // The inner loop compares it with the rest of the string.
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    frequency[i]++; // Increment frequency if a duplicate is found.
                    chars[j] = '\0'; // Mark the duplicate to avoid counting it again.
                }
            }
        }

        // --- Create the Final Result Array ---
        ArrayList<String> resultList = new ArrayList<>();
        // Iterate through the modified arrays to build the final output.
        for (int i = 0; i < chars.length; i++) {
            // Only include characters that have not been marked as duplicates.
            if (chars[i] != '\0') {
                String charDescription = (chars[i] == ' ') ? "' ' (space)" : "'" + chars[i] + "'";
                resultList.add(charDescription + " appears " + frequency[i] + " time(s)");
            }
        }
        
        return resultList.toArray(new String[0]);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user.
        System.out.print("Enter a string to find character frequencies: ");
        String userInput = scanner.nextLine();

        // Call the method to find the frequencies.
        String[] frequencies = findCharFrequency(userInput);

        // Display the final results.
        System.out.println("\n--- Character Frequency Report ---");
        if (frequencies.length == 0) {
            System.out.println("The input string is empty.");
        } else {
            for (String result : frequencies) {
                System.out.println(result);
            }
        }
        
        scanner.close();
    }
}