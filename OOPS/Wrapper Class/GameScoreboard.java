public class GameScoreboard {

    public static void main(String[] args) {
        Integer[] scores = {100, null, 250, 0, null, 75};
        int notPlayedCount = 0;
        int totalScore = 0;

        for (Integer score : scores) {
            if (score == null) {
                notPlayedCount++;
            } else {
                totalScore += score;
            }
        }

        System.out.println("Players not played: " + notPlayedCount);
        System.out.println("Total score: " + totalScore);
    }
}
