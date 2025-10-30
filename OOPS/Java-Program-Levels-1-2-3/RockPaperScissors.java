import java.util.Scanner;

public class RockPaperScissors {

    /**
     * Generates the computer's choice randomly.
     * @return A String: "Rock", "Paper", or "Scissors".
     */
    public static String getComputerChoice() {
        // Math.random() returns a double between 0.0 and < 1.0
        int choice = (int) (Math.random() * 3); // Generates 0, 1, or 2

        switch (choice) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            default: // case 2
                return "Scissors";
        }
    }

    /**
     * Determines the winner of a single round based on game rules.
     * @param playerChoice The user's choice.
     * @param computerChoice The computer's choice.
     * @return A String indicating the winner: "Player", "Computer", or "Draw".
     */
    public static String findWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "Draw";
        }

        switch (playerChoice) {
            case "Rock":
                return (computerChoice.equals("Scissors")) ? "Player" : "Computer";
            case "Paper":
                return (computerChoice.equals("Rock")) ? "Player" : "Computer";
            case "Scissors":
                return (computerChoice.equals("Paper")) ? "Player" : "Computer";
        }
        return ""; // Should not be reached
    }

    /**
     * Calculates win counts and percentages for the player and computer.
     * @param playerWins Total wins for the player.
     * @param computerWins Total wins for the computer.
     * @param totalGames Total number of games played.
     * @return A 2D String array with formatted statistics.
     */
    public static String[][] calculateStats(int playerWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][3];
        // Handle case with no games to avoid division by zero.
        double playerWinPct = (totalGames == 0) ? 0 : ((double) playerWins / totalGames) * 100;
        double computerWinPct = (totalGames == 0) ? 0 : ((double) computerWins / totalGames) * 100;

        // Player Stats
        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.format("%.2f%%", playerWinPct);

        // Computer Stats
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f%%", computerWinPct);

        return stats;
    }

    /**
     * Displays the round-by-round history and the final statistics table.
     * @param gameHistory A 2D array containing the details of each game.
     * @param stats A 2D array containing the final win statistics.
     */
    public static void displayResults(String[][] gameHistory, String[][] stats) {
        System.out.println("\n--- Game History ---");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-10s%n", "Round", "Player", "Computer", "Winner");
        System.out.println("-----------------------------------------------------");
        for (String[] game : gameHistory) {
            System.out.printf("%-10s | %-12s | %-12s | %-10s%n", game[0], game[1], game[2], game[3]);
        }
        System.out.println("-----------------------------------------------------");

        System.out.println("\n--- Final Statistics ---");
        System.out.println("-------------------------------------------");
        System.out.printf("%-12s | %-10s | %-12s%n", "Player", "Wins", "Win Rate");
        System.out.println("-------------------------------------------");
        for (String[] statLine : stats) {
            System.out.printf("%-12s | %-10s | %-12s%n", statLine[0], statLine[1], statLine[2]);
        }
        System.out.println("-------------------------------------------");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        System.out.print("How many rounds of Rock-Paper-Scissors do you want to play? ");
        int numGames = scanner.nextInt();
        String[][] gameHistory = new String[numGames][4];

        for (int i = 0; i < numGames; i++) {
            System.out.printf("\n--- Round %d ---\n", i + 1);
            System.out.print("Enter your choice (1 for Rock, 2 for Paper, 3 for Scissors): ");
            int playerChoiceNum = scanner.nextInt();
            String playerChoiceStr = "";

            switch (playerChoiceNum) {
                case 1: playerChoiceStr = "Rock"; break;
                case 2: playerChoiceStr = "Paper"; break;
                case 3: playerChoiceStr = "Scissors"; break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    i--; // Decrement i to repeat the current round.
                    continue;
            }

            String computerChoiceStr = getComputerChoice();
            System.out.println("You chose: " + playerChoiceStr);
            System.out.println("Computer chose: " + computerChoiceStr);

            String winner = findWinner(playerChoiceStr, computerChoiceStr);
            System.out.println("Result: " + (winner.equals("Draw") ? "It's a Draw!" : winner + " wins!"));

            // Update stats
            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;

            // Record history
            gameHistory[i][0] = "Round " + (i + 1);
            gameHistory[i][1] = playerChoiceStr;
            gameHistory[i][2] = computerChoiceStr;
            gameHistory[i][3] = winner;
        }

        // After all games, calculate and display results.
        String[][] finalStats = calculateStats(playerWins, computerWins, numGames);
        displayResults(gameHistory, finalStats);

        scanner.close();
    }
}