import java.util.*;

public class NumberGuessingGame {

    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    public static String getUserFeedback(int guess, Scanner sc) {
        System.out.println("Computer guesses: " + guess);
        System.out.print("Is it High (H), Low (L), or Correct (C)? ");
        return sc.nextLine().trim().toUpperCase();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Think of a number between 1 and 100. I will try to guess it!");
        
        int low = 1;
        int high = 100;
        boolean guessed = false;

        while (!guessed && low <= high) {
            int guess = generateGuess(low, high);
            String feedback = getUserFeedback(guess, sc);

            switch (feedback) {
                case "H":
                    high = guess - 1;
                    break;
                case "L":
                    low = guess + 1;
                    break;
                case "C":
                    System.out.println("Yay! I guessed your number " + guess + " correctly!");
                    guessed = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter H, L, or C.");
            }
        }

        if (!guessed) {
            System.out.println("Hmm, something went wrong. Are you sure you gave correct feedback?");
        }
    }
}
