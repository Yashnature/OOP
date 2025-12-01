import java.util.Scanner;

public class StringTrimmer {

    /**
     * Finds the start and end indices of a string, excluding leading/trailing spaces.
     * @param text The input string.
     * @return A 1D int array containing [startIndex, endIndex].
     */
    public static int[] findTrimIndices(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Find the first non-space character from the beginning.
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Find the first non-space character from the end.
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    /**
     * Creates a substring from a given string and a start/end index (inclusive).
     * @param text The original string.
     * @param startIndex The starting index, inclusive.
     * @param endIndex The ending index, inclusive.
     * @return The extracted substring.
     */
    public static String customSubstring(String text, int startIndex, int endIndex) {
        // If start index is past the end, the string was empty or all spaces.
        if (startIndex > endIndex) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    /**
     * Compares two strings character by character for equality.
     * @param str1 The first string.
     * @param str2 The second string.
     * @return true if the strings are identical, false otherwise.
     */
    public static boolean areStringsEqual(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Take user input.
        System.out.print("Enter a string with leading and/or trailing spaces: ");
        String userInput = scanner.nextLine();

        // 2. Use the custom methods to trim the string.
        int[] indices = findTrimIndices(userInput);
        String customTrimmedResult = customSubstring(userInput, indices[0], indices[1]);

        // 3. Use the built-in trim() method for comparison.
        String builtinTrimmedResult = userInput.trim();
        
        System.out.println("-------------------------------------------------");
        System.out.println("Custom Trim Method Result:  \"" + customTrimmedResult + "\"");
        System.out.println("Built-in Trim Method Result: \"" + builtinTrimmedResult + "\"");
        System.out.println("-------------------------------------------------");

        // 4. Compare the results and display the final verdict.
        boolean areEqual = areStringsEqual(customTrimmedResult, builtinTrimmedResult);
        if (areEqual) {
            System.out.println("✅ Success! The results from both methods match.");
        } else {
            System.out.println("❌ Error! The results do not match.");
        }

        scanner.close();
    }
}