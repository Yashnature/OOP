import java.util.*;

class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Player)) return false;
        Player p = (Player) obj;
        return name.equals(p.name);
    }
}

class Match {
    Player player1;
    Player player2;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String toString() {
        return player1 + " vs " + player2;
    }
}

class Result {
    Match match;
    Player winner;

    public Result(Match match, Player winner) {
        this.match = match;
        this.winner = winner;
    }

    public String toString() {
        return "Result: " + winner + " won " + match;
    }
}

class Score implements Comparable<Score> {
    Player player;
    int points;

    public Score(Player player, int points) {
        this.player = player;
        this.points = points;
    }

    @Override
    public int compareTo(Score other) {
        return Integer.compare(other.points, this.points);
    }

    public String toString() {
        return player + " - " + points + " pts";
    }
}

public class TournamentTracker {
    Set<Player> registeredPlayers = new HashSet<>();
    Queue<Match> matchQueue = new LinkedList<>();
    List<Result> matchResults = new ArrayList<>();
    TreeSet<Score> leaderboard = new TreeSet<>();
    Map<Player, Integer> playerScores = new HashMap<>();

    public void registerPlayer(Player p) {
        registeredPlayers.add(p);
        playerScores.putIfAbsent(p, 0);
    }

    public void scheduleMatch(Match m) {
        if (registeredPlayers.contains(m.player1) && registeredPlayers.contains(m.player2)) {
            matchQueue.add(m);
        }
    }

    public void processMatch() {
        if (matchQueue.isEmpty()) return;
        Match m = matchQueue.poll();
        Player winner = Math.random() > 0.5 ? m.player1 : m.player2;
        matchResults.add(new Result(m, winner));
        playerScores.put(winner, playerScores.get(winner) + 3);
        updateLeaderboard();
    }

    private void updateLeaderboard() {
        leaderboard.clear();
        for (var entry : playerScores.entrySet()) {
            leaderboard.add(new Score(entry.getKey(), entry.getValue()));
        }
    }

    public void showLeaderboard() {
        System.out.println("=== Leaderboard ===");
        for (Score s : leaderboard) System.out.println(s);
    }

    public static void main(String[] args) {
        TournamentTracker tracker = new TournamentTracker();

        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");
        Player p3 = new Player("Charlie");

        tracker.registerPlayer(p1);
        tracker.registerPlayer(p2);
        tracker.registerPlayer(p3);

        tracker.scheduleMatch(new Match(p1, p2));
        tracker.scheduleMatch(new Match(p2, p3));
        tracker.scheduleMatch(new Match(p1, p3));

        tracker.processMatch();
        tracker.processMatch();
        tracker.processMatch();

        tracker.showLeaderboard();
    }
}
