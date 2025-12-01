import java.util.Scanner;

public class StringIndexDemo {

    /**
     * This method is designed to CAUSE a StringIndexOutOfBoundsException.
     * It tries to access an index equal to the string's length, which is always out of bounds.
     *
     * @param text The input string from the user.
     */
    public static void generateException(String text) {
        System.out.println("\n--- Inside generateException() ---");
        System.out.printf("The string is \"%s\" with length %d. Valid indices are 0 to %d.%n", 
                           text, text.length(), text.length() - 1);
        
        int invalidIndex = text.length();
        System.out.println("Attempting to access the character at index: " + invalidIndex);

        // This line will cause the exception 💥
        char character = text.charAt(invalidIndex);

        // This line is never reached because the program crashes.
        System.out.println("This message will not appear.");
    }

    /**
     * This method demonstrates how to HANDLE a StringIndexOutOfBoundsException.
     * The risky code is placed inside a try-catch block to prevent a crash.
     *
     * @param text The input string from the user.
     */
    public static void handleException(String text) {
        System.out.println("\n--- Inside handleException() ---");
        System.out.printf("The string is \"%s\" with length %d. Valid indices are 0 to %d.%n", 
                           text, text.length(), text.length() - 1);

        try {
            // Put the potentially problematic code in the 'try' block.
            int invalidIndex = text.length();
            System.out.println("Attempting to access the character at index: " + invalidIndex);
            char character = text.charAt(invalidIndex);
            System.out.println("Character found: " + character);

        } catch (StringIndexOutOfBoundsException e) {
            // If the specific exception occurs, this 'catch' block is executed.
            System.out.println("✅ Exception Handled!");
            System.out.println("Error: The index you tried to access is outside the valid range.");
        }

        // Program execution continues because the exception was caught.
        System.out.println("Program execution continues after the catch block.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter some text: ");
        String userInput = scanner.nextLine();

        // --- Part 1: Call the method that generates the exception ---
        // To see the program crash with an error, uncomment the line below.
        // generateException(userInput);

        // --- Part 2: Call the method that handles the exception ---
        // This call demonstrates the safe way to handle the potential error.
        handleException(userInput);

        scanner.close();
    }
}