import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TextSplitter {

    /**
     * Splits a string into words without using the built-in split() method.
     * It iterates through the string, building words character by character.
     * A space character is treated as a delimiter between words.
     *
     * @param text The line of text to be split.
     * @return An array of strings, where each element is a word.
     */
    public static String[] customSplit(String text) {
        // Use an ArrayList to dynamically store the words found.
        ArrayList<String> wordList = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == ' ') {
                // If a space is found, the current word is complete.
                if (currentWord.length() > 0) {
                    wordList.add(currentWord.toString());
                    currentWord.setLength(0); // Reset for the next word.
                }
            } else {
                // If it's not a space, add the character to the current word.
                currentWord.append(c);
            }
        }

        // Add the last word if the text does not end with a space.
        if (currentWord.length() > 0) {
            wordList.add(currentWord.toString());
        }

        // Convert the ArrayList to a standard String array and return it.
        return wordList.toArray(new String[0]);
    }

    /**
     * Compares two String arrays to check for equality.
     * It checks if the lengths are the same and if each element is identical.
     *
     * @param arr1 The first string array.
     * @param arr2 The second string array.
     * @return true if the arrays are identical, false otherwise.
     */
    public static boolean areStringArraysEqual(String[] arr1, String[] arr2) {
        // If the number of words is different, the arrays are not equal.
        if (arr1.length != arr2.length) {
            return false;
        }

        // Compare each word at the same position in both arrays.
        for (int i = 0; i < arr1.length; i++) {
            // Use .equals() for string comparison, not ==.
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        // If the loop completes, the arrays are identical.
        return true;
    }

    /**
     * Finds the length of a string without using the built-in .length() method.
     * This method is included as requested by the hint but is not used by the split logic.
     */
    public static int findLengthWithoutMethod(String text) {
        int i = 0;
        try {
            while (true) {
                text.charAt(i);
                i++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return i;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take a full line of text as input.
        System.out.print("Enter a line of text to split: ");
        String userInput = scanner.nextLine();
        
        System.out.println("-------------------------------------------------");

        // Split the text using the custom method.
        String[] customResult = customSplit(userInput);
        System.out.println("Custom Split Result:   " + Arrays.toString(customResult));

        // Split the text using the built-in method.
        // The "\\s+" regex splits by one or more whitespace characters, matching our logic.
        String[] builtinResult = userInput.trim().split("\\s+");
        System.out.println("Built-in Split Result: " + Arrays.toString(builtinResult));
        
        System.out.println("-------------------------------------------------");
        
        // Compare the two arrays and display the final result.
        boolean areEqual = areStringArraysEqual(customResult, builtinResult);
        if (areEqual) {
            System.out.println("✅ Success! The results from both methods match.");
        } else {
            System.out.println("❌ Error! The results do not match.");
        }

        scanner.close();
    }
}