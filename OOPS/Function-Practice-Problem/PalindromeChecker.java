import java.util.*;

public class PalindromeChecker {

    public static String takeInput(Scanner sc) {
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    public static boolean isPalindrome(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = clean.length() - 1;
        while (i < j) {
            if (clean.charAt(i) != clean.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void displayResult(String text, boolean result) {
        if (result) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = takeInput(sc);
        boolean result = isPalindrome(input);
        displayResult(input, result);
    }
}
