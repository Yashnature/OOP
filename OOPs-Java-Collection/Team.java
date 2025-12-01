import java.util.*;

class Team implements Comparable<Team> {
    String name;
    int points;

    public Team(String name) {
        this.name = name;
        this.points = 0;
    }

    @Override
    public int compareTo(Team other) {
        int pointCompare = Integer.compare(other.points, this.points);
        if (pointCompare == 0) return this.name.compareTo(other.name);
        return pointCompare;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Team)) return false;
        Team t = (Team) obj;
        return name.equals(t.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return name + " - " + points + " pts";
    }
}

class Match {
    Team team1;
    Team team2;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public String toString() {
        return team1.name + " vs " + team2.name;
    }
}

class Result {
    Match match;
    Team winner;

    public Result(Match match, Team winner) {
        this.match = match;
        this.winner = winner;
    }

    public String toString() {
        return match + " | Winner: " + (winner != null ? winner.name : "Draw");
    }
}

public class TournamentScheduler {
    Set<Team> teams = new HashSet<>();
    Queue<Match> matchQueue = new LinkedList<>();
    List<Result> results = new ArrayList<>();
    TreeSet<Team> leaderboard = new TreeSet<>();

    public void registerTeam(Team t) {
        teams.add(t);
    }

    public void scheduleMatch(Match m) {
        if (teams.contains(m.team1) && teams.contains(m.team2)) {
            matchQueue.add(m);
        }
    }

    public void processMatch() {
        if (matchQueue.isEmpty()) return;
        Match m = matchQueue.poll();
        Team winner = Math.random() > 0.5 ? m.team1 : m.team2;
        winner.points += 3;
        results.add(new Result(m, winner));
        updateLeaderboard();
        System.out.println("Processed: " + m + " | Winner: " + winner.name);
    }

    private void updateLeaderboard() {
        leaderboard.clear();
        leaderboard.addAll(teams);
    }

    public void showLeaderboard() {
        System.out.println("=== Leaderboard ===");
        for (Team t : leaderboard) System.out.println(t);
    }

    public static void main(String[] args) {
        TournamentScheduler scheduler = new TournamentScheduler();

        Team t1 = new Team("Tigers");
        Team t2 = new Team("Lions");
        Team t3 = new Team("Eagles");

        scheduler.registerTeam(t1);
        scheduler.registerTeam(t2);
        scheduler.registerTeam(t3);

        scheduler.scheduleMatch(new Match(t1, t2));
        scheduler.scheduleMatch(new Match(t2, t3));
        scheduler.scheduleMatch(new Match(t1, t3));

        scheduler.processMatch();
        scheduler.processMatch();
        scheduler.processMatch();

        scheduler.showLeaderboard();
    }
}
