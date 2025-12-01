import java.util.Scanner;

public class VowelConsonantCounter {

    /**
     * Checks if a character is a vowel, consonant, or neither.
     * @param c The character to check.
     * @return A String: "Vowel", "Consonant", or "Not a Letter".
     */
    public static String checkCharType(char c) {
        // 1. Convert character to lowercase if it's uppercase.
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32); // The ASCII difference between 'a' and 'A' is 32.
        }

        // 2. Check if the lowercase character is a vowel.
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return "Vowel";
        }
        // 3. Check if it's any other letter (a consonant).
        else if (c >= 'a' && c <= 'z') {
            return "Consonant";
        }
        // 4. If none of the above, it's not part of the alphabet.
        else {
            return "Not a Letter";
        }
    }

    /**
     * Counts the total number of vowels and consonants in a string.
     * @param text The input string to analyze.
     * @return A 1D int array of size 2: [vowelCount, consonantCount].
     */
    public static int[] countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;

        // Iterate through each character of the string.
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            String charType = checkCharType(currentChar);

            // Increment the appropriate counter based on the character type.
            if (charType.equals("Vowel")) {
                vowelCount++;
            } else if (charType.equals("Consonant")) {
                consonantCount++;
            }
            // "Not a Letter" types (spaces, numbers, symbols) are ignored.
        }

        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Take user input.
        System.out.print("Enter a line of text: ");
        String userInput = scanner.nextLine();

        // 2. Call the method to get the counts.
        int[] counts = countVowelsAndConsonants(userInput);
        int totalVowels = counts[0];
        int totalConsonants = counts[1];

        // 3. Display the final results.
        System.out.println("\n--- Analysis Complete ---");
        System.out.println("Original Text: " + userInput);
        System.out.println("Total Vowels:     " + totalVowels);
        System.out.println("Total Consonants: " + totalConsonants);

        scanner.close();
    }
}