import java.util.Arrays;
import java.util.Scanner;

public class CardDeck {

    /**
     * Creates and initializes a standard 52-card deck.
     * @param suits An array of card suits.
     * @param ranks An array of card ranks.
     * @return A String array representing the complete, ordered deck.
     */
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int numCards = suits.length * ranks.length;
        String[] deck = new String[numCards];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    /**
     * Shuffles the deck of cards in place using the Fisher-Yates algorithm.
     * @param deck The deck of cards to be shuffled.
     */
    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        // Iterate through the deck, swapping each card with a random one from the unshuffled part.
        for (int i = 0; i < n; i++) {
            // Find a random index from the remaining unshuffled cards (i to n-1).
            int randomCardIndex = i + (int) (Math.random() * (n - i));
            
            // Swap the current card (at i) with the randomly selected card.
            String temp = deck[i];
            deck[i] = deck[randomCardIndex];
            deck[randomCardIndex] = temp;
        }
    }

    /**
     * Distributes cards from the deck to a number of players.
     * @param deck The shuffled deck of cards.
     * @param numPlayers The number of players to deal to.
     * @param cardsPerPlayer The number of cards each player receives.
     * @return A 2D String array representing players' hands, or null if the deal is impossible.
     */
    public static String[][] dealCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        // Check if there are enough cards in the deck to complete the deal.
        if (numPlayers * cardsPerPlayer > deck.length) {
            System.out.println("Error: Not enough cards in the deck to deal as requested.");
            return null;
        }

        String[][] playersHands = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;

        // Deal cards one by one to each player, like in a real game.
        for (int card = 0; card < cardsPerPlayer; card++) {
            for (int player = 0; player < numPlayers; player++) {
                playersHands[player][card] = deck[cardIndex++];
            }
        }
        return playersHands;
    }

    /**
     * Prints the cards held by each player.
     * @param hands A 2D array representing the players' hands.
     */
    public static void printHands(String[][] hands) {
        System.out.println("\n--- Dealt Cards ---");
        for (int i = 0; i < hands.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + "'s Hand:");
            System.out.println(Arrays.toString(hands[i]));
        }
    }

    public static void main(String[] args) {
        // Define the properties of a standard deck.
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
        // 1. Create the deck.
        String[] deck = initializeDeck(suits, ranks);
        System.out.println("Deck initialized with " + deck.length + " cards.");

        // 2. Shuffle the deck.
        shuffleDeck(deck);
        System.out.println("Deck has been shuffled.");

        // 3. Get user input for dealing.
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the number of players: ");
        int numPlayers = scanner.nextInt();
        System.out.print("Enter the number of cards to deal per player: ");
        int cardsPerPlayer = scanner.nextInt();
        
        // 4. Distribute the cards.
        String[][] playerHands = dealCards(deck, numPlayers, cardsPerPlayer);

        // 5. Print the hands if the deal was successful.
        if (playerHands != null) {
            printHands(playerHands);
        }
        
        scanner.close();
    }
}