import java.util.Scanner;
import java.util.Arrays;

/**
 * This program converts a string to a character array using a custom method
 * and compares the result against the built-in toCharArray() method.
 */
public class CharArrayConverter {

    /**
     * Converts a String into a character array without using toCharArray().
     *
     * @param str The input string.
     * @return A char[] array containing the characters of the string.
     */
    public static char[] getCharsFromString(String str) {
        // 1. Create a new char array with the same length as the string.
        char[] charArray = new char[str.length()];

        // 2. Loop through the string.
        for (int i = 0; i < str.length(); i++) {
            // 3. Assign the character at each index to the new array.
            charArray[i] = str.charAt(i);
        }

        // 4. Return the populated array.
        return charArray;
    }

    /**
     * Compares two character arrays to see if they are identical.
     *
     * @param arr1 The first character array.
     * @param arr2 The second character array.
     * @return true if the arrays have the same length and elements, false otherwise.
     */
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        // 1. If the array lengths are different, they cannot be equal.
        if (arr1.length != arr2.length) {
            return false;
        }

        // 2. Loop through the arrays.
        for (int i = 0; i < arr1.length; i++) {
            // 3. If any element is different, the arrays are not equal.
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        // 4. If the loop completes, all elements matched.
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Get User Input ---
        System.out.print("Enter a string to convert to a character array: ");
        String inputText = scanner.next();
        
        System.out.println("--------------------------------------------------");

        // --- Generate Character Arrays ---
        // 1. Use the custom user-defined method.
        char[] customResultArray = getCharsFromString(inputText);

        // 2. Use the String built-in toCharArray() method.
        char[] builtinResultArray = inputText.toCharArray();

        // Display the contents of both arrays for visual confirmation.
        // Arrays.toString() creates a nice, readable string representation of an array.
        System.out.println("Custom method result:   " + Arrays.toString(customResultArray));
        System.out.println("Built-in method result: " + Arrays.toString(builtinResultArray));

        System.out.println("--------------------------------------------------");

        // --- Compare the two arrays ---
        boolean areArraysIdentical = compareCharArrays(customResultArray, builtinResultArray);

        // --- Display the final result ---
        if (areArraysIdentical) {
            System.out.println("✅ Success! The two character arrays are identical.");
        } else {
            System.out.println("❌ Error! The arrays do not match.");
        }

        scanner.close();
    }
}