import java.util.Scanner;

public class NumberFormatDemo {

    /**
     * This method is designed to CAUSE a NumberFormatException.
     * It attempts to parse a string directly, which will crash if the string is not a valid integer.
     *
     * @param text The input string from the user.
     */
    public static void generateException(String text) {
        System.out.println("\n--- Inside generateException() ---");
        System.out.println("Attempting to parse the string: \"" + text + "\"");

        // This line will cause the exception if 'text' is not a valid number 💥
        int number = Integer.parseInt(text);

        // This line is only reached if the parsing is successful.
        System.out.println("Success! The parsed number is: " + number);
    }

    /**
     * This method demonstrates how to HANDLE a NumberFormatException.
     * It uses a try-catch block to manage the error without crashing.
     *
     * @param text The input string from the user.
     */
    public static void handleException(String text) {
        System.out.println("\n--- Inside handleException() ---");
        System.out.println("Attempting to parse \"" + text + "\" inside a try-catch block...");

        try {
            // The risky operation is placed in the 'try' block.
            int number = Integer.parseInt(text);
            System.out.println("Success! The parsed number is: " + number);

        } catch (NumberFormatException e) {
            // This block specifically catches the formatting error.
            System.out.println("✅ Specific Exception Handled (NumberFormatException)!");
            System.out.println("Error: The provided string is not a valid integer.");

        } catch (RuntimeException e) {
            // This is a generic catch block for any other unexpected runtime errors.
            System.out.println("✅ Generic Runtime Exception Handled!");
            System.out.println("An unexpected runtime error occurred.");
        }

        // Program execution continues regardless of whether an exception was caught.
        System.out.println("Program execution continues after the try-catch block.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to convert to an integer: ");
        String userInput = scanner.nextLine();

        // --- Part 1: Call the method that generates the exception ---
        // To see the program crash with an error, uncomment the line below 
        // and enter a non-numeric string (e.g., "hello").
        // generateException(userInput);

        // --- Part 2: Call the method that handles the exception ---
        // This call demonstrates the safe way to handle the potential error.
        handleException(userInput);

        scanner.close();
    }
}