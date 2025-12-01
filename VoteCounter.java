import java.util.*;
public class VoteCounter {
    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();
        String[] cast = {"A","B","A","C","A","B","A","C","C","A"};
        for (String c : cast)
            votes.put(c, votes.getOrDefault(c,0)+1);
        System.out.println(votes);
        String winner = null;
        int max = -1;
        for (var e : votes.entrySet())
            if (e.getValue() > max) { max = e.getValue(); winner = e.getKey(); }
        System.out.println("Winner = " + winner);
    }
}
