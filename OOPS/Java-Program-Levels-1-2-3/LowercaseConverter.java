import java.util.Scanner;

public class LowercaseConverter {

    /**
     * Converts a string to lowercase using ASCII value logic.
     * It checks each character, and if it's an uppercase letter ('A' through 'Z'),
     * it adds 32 to its ASCII value to get the lowercase equivalent.
     *
     * @param text The original string.
     * @return A new string in all lowercase.
     */
    public static String customToLowerCase(String text) {
        // StringBuilder is efficient for building new strings.
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            // Check if the character is an uppercase English letter.
            if (currentChar >= 'A' && currentChar <= 'Z') {
                // Convert to lowercase by adding 32 to its ASCII value.
                char lowerChar = (char) (currentChar + 32);
                resultBuilder.append(lowerChar);
            } else {
                // If it's not an uppercase letter, append it without change.
                resultBuilder.append(currentChar);
            }
        }
        return resultBuilder.toString();
    }

    /**
     * Compares two strings character by character to check for equality.
     *
     * @param str1 The first string.
     * @param str2 The second string.
     * @return true if the strings are identical, false otherwise.
     */
    public static boolean areStringsEqual(String str1, String str2) {
        // Strings with different lengths cannot be equal.
        if (str1.length() != str2.length()) {
            return false;
        }

        // Compare each character in the same position.
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false; // A mismatch was found.
            }
        }

        // If the loop finishes, no mismatches were found.
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Take user input for the complete text.
        System.out.print("Enter a line of text to convert to lowercase: ");
        String originalText = scanner.nextLine();
        
        System.out.println("-------------------------------------------------");

        // 2. Convert using the custom, user-defined method.
        String customResult = customToLowerCase(originalText);
        System.out.println("Custom Method Result:   " + customResult);

        // 3. Convert using the built-in Java method.
        String builtinResult = originalText.toLowerCase();
        System.out.println("Built-in Method Result: " + builtinResult);
        
        System.out.println("-------------------------------------------------");

        // 4. Compare the two resulting strings using our custom comparison method.
        boolean areEqual = areStringsEqual(customResult, builtinResult);

        // 5. Display the final result of the comparison.
        if (areEqual) {
            System.out.println("✅ Success! The results from both methods match.");
        } else {
            System.out.println("❌ Error! The results do not match.");
        }

        scanner.close();
    }
}