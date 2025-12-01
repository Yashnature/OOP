import java.util.ArrayList;
import java.util.Scanner;

public class WordLengthAnalyzer {

    /**
     * Splits a string into words using charAt() logic, ignoring extra spaces.
     * @param text The line of text to be split.
     * @return An array of strings, where each element is a word.
     */
    public static String[] customSplit(String text) {
        ArrayList<String> wordList = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (currentWord.length() > 0) {
                    wordList.add(currentWord.toString());
                    currentWord.setLength(0); // Reset for the next word
                }
            } else {
                currentWord.append(c);
            }
        }
        // Add the last word if the text doesn't end with a space
        if (currentWord.length() > 0) {
            wordList.add(currentWord.toString());
        }
        return wordList.toArray(new String[0]);
    }

    /**
     * Finds the length of a string by counting characters until an exception is thrown.
     * @param text The string whose length is to be found.
     * @return The integer length of the string.
     */
    public static int findLengthWithoutMethod(String text) {
        int i = 0;
        try {
            // Loop until charAt(i) throws an exception
            while (true) {
                text.charAt(i);
                i++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // The index 'i' that caused the exception is the length
            return i;
        }
    }

    /**
     * Creates a 2D array containing words and their corresponding lengths.
     * @param words A 1D array of words.
     * @return A 2D String array where each row is [word, length].
     */
    public static String[][] createWordLengthArray(String[] words) {
        String[][] wordData = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            // Use our custom method to find the length
            int length = findLengthWithoutMethod(currentWord);

            // Store the word and its length (as a String) in the 2D array
            wordData[i][0] = currentWord;
            wordData[i][1] = String.valueOf(length);
        }
        return wordData;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Take user input
        System.out.print("Enter a line of text: ");
        String userInput = scanner.nextLine();

        // 2. Split the text into an array of words
        String[] words = customSplit(userInput);

        // 3. Create the 2D array of words and their lengths
        String[][] wordAndLengthData = createWordLengthArray(words);

        // 4. Display the result in a tabular format
        System.out.println("\n--- Word Analysis ---");
        System.out.println("-------------------------");
        System.out.printf("%-15s | %s%n", "