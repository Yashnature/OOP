import java.util.Scanner;

public class IllegalArgumentDemo {

    /**
     * This method is designed to CAUSE an exception by passing invalid arguments.
     * Using substring() with a start index > end index will crash the program.
     *
     * @param text The input string from the user.
     */
    public static void generateException(String text) {
        System.out.println("\n--- Inside generateException() ---");
        // We'll use fixed indices to reliably cause the error.
        int startIndex = 4;
        int endIndex = 1;

        System.out.printf("Attempting to get substring from index %d to %d...%n", startIndex, endIndex);

        // This line will cause the exception 💥
        // The start index (4) is greater than the end index (1).
        String sub = text.substring(startIndex, endIndex);

        // This line is never reached.
        System.out.println("This message will not appear.");
    }

    /**
     * This method demonstrates how to HANDLE exceptions related to bad arguments.
     * It uses a try-catch block to manage the error gracefully.
     *
     * @param text The input string from the user.
     */
    public static void handleException(String text) {
        System.out.println("\n--- Inside handleException() ---");
        int startIndex = 4;
        int endIndex = 1;
        
        System.out.printf("Attempting to get substring from index %d to %d inside a try-catch block...%n", startIndex, endIndex);

        try {
            // The risky code is placed in the 'try' block.
            String sub = text.substring(startIndex, endIndex);
            System.out.println("Substring created: " + sub);

        } catch (StringIndexOutOfBoundsException e) {
            // This is the specific exception thrown for this error.
            System.out.println("✅ Specific Exception Handled (StringIndexOutOfBoundsException)!");
            System.out.println("Error: The start index cannot be greater than the end index.");

        } catch (IllegalArgumentException e) {
            // This block is here to demonstrate catching other argument-related errors.
            // It will not be triggered by this specific substring error.
            System.out.println("✅ Illegal Argument Exception Handled!");
            System.out.println("Error: A method was passed an invalid argument.");

        } catch (RuntimeException e) {
            // This is a generic catch block for any other runtime errors.
            System.out.println("✅ Generic Runtime Exception Handled!");
            System.out.println("An unexpected runtime error occurred.");
        }
        
        // Program execution continues because the exception was caught.
        System.out.println("Program execution continues after the catch block.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text (at least 5 characters long): ");
        String userInput = scanner.nextLine();

        if (userInput.length() < 5) {
            System.out.println("Please enter a longer string to run the demo correctly.");
        } else {
            // --- Part 1: Call the method that generates the exception ---
            // To see the program crash, uncomment the line below.
            // generateException(userInput);

            // --- Part 2: Call the method that handles the exception ---
            // This demonstrates the safe way to handle the potential error.
            handleException(userInput);
        }
        
        scanner.close();
    }
}