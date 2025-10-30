import java.util.Scanner;

/**
 * This program demonstrates creating a substring from a given string using two methods:
 * 1. A custom method iterating with charAt().
 * 2. The built-in String.substring() method.
 * It then compares the results of both methods.
 */
public class SubstringCreator {

    /**
     * Creates a substring from a given string using the charAt() method.
     *
     * @param text  The original string.
     * @param start The beginning index, inclusive.
     * @param end   The ending index, exclusive.
     * @return The newly created substring.
     */
    public static String createSubstringWithCharAt(String text, int start, int end) {
        // Using StringBuilder is more efficient for concatenating strings in a loop
        StringBuilder sub = new StringBuilder();

        // Loop from the start index up to (but not including) the end index
        for (int i = start; i < end; i++) {
            // Append the character at the current index 'i' to our substring
            sub.append(text.charAt(i));
        }

        // Convert the StringBuilder back to a String and return it
        return sub.toString();
    }

    /**
     * Compares two strings character by character using the charAt() method.
     *
     * @param str1 The first string to compare.
     * @param str2 The second string to compare.
     * @return true if the strings are identical, false otherwise.
     */
    public static boolean areStringsEqual(String str1, String str2) {
        // If lengths are different, they can't be equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // Loop through and compare each character
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false; // Found a mismatch
            }
        }

        // If the loop finishes, all characters matched
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Get User Input ---
        System.out.print("Enter the main string: ");
        String mainString = scanner.next();

        System.out.print("Enter the start index: ");
        int startIndex = scanner.nextInt();

        System.out.print("Enter the end index: ");
        int endIndex = scanner.nextInt();

        // --- Input Validation ---
        if (startIndex < 0 || endIndex > mainString.length() || startIndex > endIndex) {
            System.out.println("\nError: Invalid indices.");
            System.out.printf("Please ensure that 0 <= start (%d) <= end (%d) <= string length (%d).%n", 
                               startIndex, endIndex, mainString.length());
            scanner.close();
            return; // Exit program
        }
        
        System.out.println("----------------------------------------");

        // --- Create Substrings ---
        // 1. Using our custom method with charAt()
        String customSubstring = createSubstringWithCharAt(mainString, startIndex, endIndex);
        System.out.println("Custom substring result:    \"" + customSubstring + "\"");

        // 2. Using the built-in Java method
        String builtinSubstring = mainString.substring(startIndex, endIndex);
        System.out.println("Built-in substring result:  \"" + builtinSubstring + "\"");
        
        System.out.println("----------------------------------------");

        // --- Compare the Results ---
        boolean areEqual = areStringsEqual(customSubstring, builtinSubstring);

        if (areEqual) {
            System.out.println("✅ Success! The two substrings are identical.");
        } else {
            System.out.println("❌ Error! The two substrings do not match.");
        }

        scanner.close();
    }
}