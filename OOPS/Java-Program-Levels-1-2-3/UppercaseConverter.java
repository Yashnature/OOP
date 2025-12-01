import java.util.Scanner;

public class UppercaseConverter {

    /**
     * Converts a string to uppercase using ASCII value logic.
     * It checks each character and if it's a lowercase letter ('a' through 'z'),
     * it subtracts 32 from its ASCII value to get the uppercase equivalent.
     *
     * @param text The original string.
     * @return A new string in all uppercase.
     */
    public static String customToUpperCase(String text) {
        // StringBuilder is efficient for building strings in a loop.
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            // Check if the character is a lowercase English letter.
            if (currentChar >= 'a' && currentChar <= 'z') {
                // Convert to uppercase by subtracting 32 from its ASCII value.
                char upperChar = (char) (currentChar - 32);
                resultBuilder.append(upperChar);
            } else {
                // If not a lowercase letter, append it as is.
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
        // If lengths are different, they cannot be equal.
        if (str1.length() != str2.length()) {
            return false;
        }

        // Compare each character at the same position.
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false; // Return false at the first mismatch.
            }
        }

        // If the loop completes, all characters matched.
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Take user input for the complete text.
        System.out.print("Enter a line of text to convert to uppercase: ");
        String originalText = scanner.nextLine();
        
        System.out.println("-------------------------------------------------");

        // 2. Convert using the custom method.
        String customResult = customToUpperCase(originalText);
        System.out.println("Custom Method Result:  " + customResult);

        // 3. Convert using the built-in Java method.
        String builtinResult = originalText.toUpperCase();
        System.out.println("Built-in Method Result: " + builtinResult);
        
        System.out.println("-------------------------------------------------");

        // 4. Compare the two resulting strings using our custom comparison method.
        boolean areEqual = areStringsEqual(customResult, builtinResult);

        // 5. Display the final result.
        if (areEqual) {
            System.out.println("✅ Success! The results from both methods match.");
        } else {
            System.out.println("❌ Error! The results do not match.");
        }

        scanner.close();
    }
}