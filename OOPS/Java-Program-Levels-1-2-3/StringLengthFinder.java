import java.util.Scanner;

public class StringLengthFinder {

    /**
     * Finds the length of a string without using the built-in .length() method.
     * It repeatedly accesses characters at increasing indices until a
     * StringIndexOutOfBoundsException is thrown. The count at that moment is the length.
     *
     * @param text The string whose length is to be found.
     * @return The integer length of the string.
     */
    public static int findLengthWithoutMethod(String text) {
        int count = 0;
        try {
            // This loop will run until it causes an exception.
            while (true) {
                text.charAt(count); // Try to access the character at the current index.
                count++;            // If successful, increment the count.
            }
        } catch (StringIndexOutOfBoundsException e) {
            // The exception occurs when 'count' is equal to the string's length.
            // For a string "Hi" (length 2), it successfully reads index 0 and 1.
            // When count becomes 2, charAt(2) fails, and we catch the exception.
            // The value of 'count' (which is 2) is the length.
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Take user input.
        System.out.print("Enter a string to find its length: ");
        String userInput = scanner.next();
        
        System.out.println("----------------------------------------");

        // 2. Calculate length using the custom method.
        int customLength = findLengthWithoutMethod(userInput);
        System.out.println("Result from custom method: " + customLength);

        // 3. Get length using the built-in method for comparison.
        int builtinLength = userInput.length();
        System.out.println("Result from built-in length() method: " + builtinLength);
        
        System.out.println("----------------------------------------");
        
        // 4. Compare and display the final result.
        if (customLength == builtinLength) {
            System.out.println("✅ Success! The results match.");
        } else {
            System.out.println("❌ Error! The results do not match.");
        }

        scanner.close();
    }
}