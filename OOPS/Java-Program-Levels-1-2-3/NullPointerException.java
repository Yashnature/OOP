public class NullPointerDemo {

    /**
     * This method is designed to CAUSE a NullPointerException.
     * It initializes a String to null and then tries to call a method on it,
     * which will crash the program.
     */
    public static void generateException() {
        String text = null; // 'text' is a reference, but it points to nothing.

        System.out.println("--- Inside generateException() ---");
        System.out.println("Attempting to find the length of a null string...");
        
        // This line will cause the exception 💥
        int length = text.length(); 
        
        // This line will never be reached because the program crashes above.
        System.out.println("This message will not appear.");
    }

    /**
     * This method demonstrates how to HANDLE a NullPointerException.
     * It places the risky code inside a try-catch block to prevent the program from crashing.
     */
    public static void handleException() {
        String text = null; // 'text' is a reference that points to nothing.

        System.out.println("--- Inside handleException() ---");
        System.out.println("Attempting the same operation, but inside a try-catch block...");
        
        try {
            // The code that might cause an exception is placed in the 'try' block.
            int length = text.length();
            System.out.println("Length is: " + length);

        } catch (NullPointerException e) {
            // If a NullPointerException occurs in the 'try' block, this code runs.
            System.out.println("✅ Exception Handled!");
            System.out.println("Error: You tried to use an object that was null.");
            // e.printStackTrace(); // Uncomment this for a detailed developer error log.
        }
        
        // Because the exception was handled, the program continues executing.
        System.out.println("Program execution continues normally after the catch block.");
    }


    public static void main(String[] args) {
        // --- Part 1: Call the method that generates the exception ---
        // To see the program crash, uncomment the line below and run.
        // generateException();


        // --- Part 2: Call the method that handles the exception ---
        // This is the refactored, safer version. This call will run without crashing.
        handleException();
    }
}