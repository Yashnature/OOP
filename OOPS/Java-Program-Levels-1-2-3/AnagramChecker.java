import java.util.Scanner;

public class AnagramChecker {

    /**
     * Checks if two strings are anagrams of each other.
     * @param str1 The first string.
     * @param str2 The second string.
     * @return true if the strings are anagrams, false otherwise.
     */
    public static boolean areAnagrams(String str1, String str2) {
        // 1. Anagrams must have the same length.
        if (str1.length() != str2.length()) {
            return false;
        }

        // 2. Create an array to act as a frequency map for all 256 ASCII characters.
        int[] charFrequencies = new int[256];

        // 3. Iterate through the first string, incrementing the count for each character.
        for (int i = 0; i < str1.length(); i++) {
            char currentChar = str1.charAt(i);
            charFrequencies[currentChar]++;
        }

        // 4. Iterate through the second string, decrementing the count for each character.
        for (int i = 0; i < str2.length(); i++) {
            char currentChar = str2.charAt(i);
            charFrequencies[currentChar]--;
        }

        // 5. If the strings are anagrams, all counts in the frequency map will be zero.
        // If any count is not zero, the strings do not match.
        for (int i = 0; i < charFrequencies.length; i++) {
            if (charFrequencies[i] != 0) {
                return false;
            }
        }

        // If all checks pass, the strings are anagrams.
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get two strings from the user.
        System.out.print("Enter the first text: ");
        String text1 = scanner.nextLine();
        System.out.print("Enter the second text: ");
        String text2 = scanner.nextLine();

        // Call the method to check if they are anagrams.
        boolean isAnagram = areAnagrams(text1, text2);

        // Display the final result.
        System.out.println("\n--- Anagram Check Result ---");
        if (isAnagram) {
            System.out.println("✅ The two texts ARE anagrams.");
        } else {
            System.out.println("❌ The two texts are NOT anagrams.");
        }

        scanner.close();
    }
}