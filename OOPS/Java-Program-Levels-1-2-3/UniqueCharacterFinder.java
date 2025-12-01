import java.util.Arrays;
import java.util.Scanner;

public class UniqueCharacterFinder {

    /**
     * Finds the length of a string without using the built-in .length() method.
     * @param text The string whose length is to be found.
     * @return The integer length of the string.
     */
    public static int findLengthWithoutMethod(String text) {
        int i = 0;
        try {
            // Loop until charAt(i) throws an out-of-bounds exception.
            while (true) {
                text.charAt(i);
                i++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // The index that caused the exception is the length.
            return i;
        }
    }

    /**
     * Finds all unique characters in a string using nested loops.
     * @param text The input string to analyze.
     * @return A char array containing only the unique characters.
     */
    public static char[] findUniqueChars(String text) {
        int length = findLengthWithoutMethod(text);
        if (length == 0) {
            return new char[0]; // Handle empty string case.
        }

        // A temporary array to hold unique characters, worst-case size.
        char[] tempArray = new char[length];
        int uniqueCount = 0;

        // 1. Loop through each character of the input string.
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isDuplicate = false;

            // 2. Check if the character already exists in our temporary array.
            for (int j = 0; j < uniqueCount; j++) {
                if (tempArray[j] == currentChar) {
                    isDuplicate = true;
                    break; // Found a duplicate, no need to check further.
                }
            }

            // 3. If it's not a duplicate, add it to our list and increment the count.
            if (!isDuplicate) {
                tempArray[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        // 4. Create a final array with the exact size of unique characters found.
        char[] resultArray = new char[uniqueCount];
        System.arraycopy(tempArray, 0, resultArray, 0, uniqueCount);

        return resultArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user.
        System.out.print("Enter a string to find its unique characters: ");
        String userInput = scanner.nextLine();

        // Call the method to find the unique characters.
        char[] uniqueChars = findUniqueChars(userInput);

        // Display the final result.
        System.out.println("\nOriginal String: " + userInput);
        // Arrays.toString() provides a nice, readable format for arrays.
        System.out.println("Unique Characters Found: " + Arrays.toString(uniqueChars));

        scanner.close();
    }
}