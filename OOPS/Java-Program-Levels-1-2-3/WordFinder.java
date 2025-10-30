import java.util.ArrayList;
import java.util.Scanner;

public class WordFinder {

    // Splits text into words using charAt() logic.
    public static String[] customSplit(String text) {
        ArrayList<String> wordList = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (currentWord.length() > 0) {
                    wordList.add(currentWord.toString());
                    currentWord.setLength(0);
                }
            } else {
                currentWord.append(c);
            }
        }
        if (currentWord.length() > 0) {
            wordList.add(currentWord.toString());
        }
        return wordList.toArray(new String[0]);
    }

    // Finds a string's length by catching an exception.
    public static int findLengthWithoutMethod(String text) {
        int i = 0;
        try {
            while (true) {
                text.charAt(i);
                i++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return i;
        }
    }

    // Creates a 2D array of words and their lengths.
    public static String[][] createWordLengthArray(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0][0];
        }
        String[][] wordData = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordData[i][0] = words[i];
            wordData[i][1] = String.valueOf(findLengthWithoutMethod(words[i]));
        }
        return wordData;
    }

    /**
     * Finds the minimum and maximum lengths from the word data array.
     * @param wordData A 2D array where each row is [word, length].
     * @return A 1D int array containing [minLength, maxLength].
     */
    public static int[] findMinMaxLengths(String[][] wordData) {
        if (wordData == null || wordData.length == 0) {
            return new int[]{0, 0}; // Handles empty input.
        }

        // Initialize min and max with the length of the first word.
        int minLength = Integer.parseInt(wordData[0][1]);
        int maxLength = minLength;

        // Iterate through the rest of the words to find the true min and max.
        for (int i = 1; i < wordData.length; i++) {
            int currentLength = Integer.parseInt(wordData[i][1]);
            if (currentLength < minLength) {
                minLength = currentLength;
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        return new int[]{minLength, maxLength};
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Take user input.
        System.out.print("Enter a line of text: ");
        String userInput = scanner.nextLine();

        // 2. Perform the analysis using the helper methods.
        String[] words = customSplit(userInput);
        String[][] wordAndLengthData = createWordLengthArray(words);
        
        if (wordAndLengthData.length == 0) {
            System.out.println("No words were found in the input.");
            scanner.close();
            return;
        }

        int[] minMax = findMinMaxLengths(wordAndLengthData);
        int shortestLength = minMax[0];
        int longestLength = minMax[1];

        String shortestWord = "";
        String longestWord = "";

        // 3. Find the first word that matches the min and max lengths.
        for (int i = 0; i < wordAndLengthData.length; i++) {
            if (Integer.parseInt(wordAndLengthData[i][1]) == shortestLength) {
                shortestWord = wordAndLengthData[i][0];
            }
            if (Integer.parseInt(wordAndLengthData[i][1]) == longestLength) {
                longestWord = wordAndLengthData[i][0];
            }
        }

        // 4. Display the final results.
        System.out.println("\n--- Analysis Complete ---");
        System.out.println("Shortest word found: \"" + shortestWord + "\" (Length: " + shortestLength + ")");
        System.out.println("Longest word found:  \"" + longestWord + "\" (Length: " + longestLength + ")");
        
        scanner.close();
    }
}