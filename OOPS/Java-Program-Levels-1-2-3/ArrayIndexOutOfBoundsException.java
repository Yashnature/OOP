import java.util.Arrays;
import java.util.Scanner;

public class ArrayIndexOutOfBoundsException {

    /**
     * This method is designed to CAUSE an ArrayIndexOutOfBoundsException.
     * It attempts to access an array index provided by the user, which will crash
     * if the index is outside the valid range.
     *
     * @param arr   The array to access.
     * @param index The index to retrieve an element from.
     */
    public static void generateException(String[] arr, int index) {
        System.out.println("\n--- Inside generateException() ---");
        System.out.println("Attempting to access element at index: " + index);

        // This line will cause the exception if 'index' is invalid 💥
        String name = arr[index];

        // This line is only reached if the index is valid.
        System.out.println("Success! The element at index " + index + " is: " + name);
    }

    /**
     * This method demonstrates how to HANDLE an ArrayIndexOutOfBoundsException.
     * It uses a try-catch block to prevent the program from crashing.
     *
     * @param arr   The array to access.
     * @param index The index to retrieve an element from.
     */
    public static void handleException(String[] arr, int index) {
        System.out.println("\n--- Inside handleException() ---");
        System.out.println("Attempting to access index " + index + " inside a try-catch block...");

        try {
            // The risky operation is placed in the 'try' block.
            String name = arr[index];
            System.out.println("Success! The element at index " + index + " is: " + name);

        } catch (ArrayIndexOutOfBoundsException e) {
            // This block specifically catches the array index error.
            System.out.println("✅ Specific Exception Handled (ArrayIndexOutOfBoundsException)!");
            System.out.printf("Error: Index %d is out of bounds for an array of size %d.%n", index, arr.length);

        } catch (RuntimeException e) {
            // A generic catch block for other potential runtime errors.
            System.out.println("✅ Generic Runtime Exception Handled!");
            System.out.println("An unexpected runtime error occurred.");
        }

        // Program execution continues because the error was managed.
        System.out.println("Program execution continues after the try-catch block.");
    }

    public static void main(String[] args) {
        // 1. Define an array of names.
        String[] names = {"L•E•V•I•", "Alice", "Bob", "Charlie"};

        System.out.println("Names in the array: " + Arrays.toString(names));
        System.out.printf("The array has %d elements. Valid indices are from 0 to %d.%n", 
                           names.length, names.length - 1);

        // 2. Take user input for the index.
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter an index to access: ");
        int userIndex = scanner.nextInt();

        // --- Part 1: Call the method that generates the exception ---
        // To see the program crash, uncomment the line below and enter an invalid index (e.g., 4 or -1).
        // generateException(names, userIndex);

        // --- Part 2: Call the method that handles the exception ---
        // This demonstrates the safe way to handle the potential error.
        handleException(names, userIndex);

        scanner.close();
    }
}