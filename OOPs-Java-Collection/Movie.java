import java.util.*;

class Movie {
    String title;
    String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String toString() {
        return title + " (" + genre + ")";
    }
}

public class StreamingApp {
    Stack<Movie> watchHistory = new Stack<>();
    List<Movie> allMovies = new ArrayList<>();
    Set<String> watchedGenres = new HashSet<>();
    Queue<Movie> upNext = new LinkedList<>();

    public void addMovie(Movie m) {
        allMovies.add(m);
    }

    public void addToUpNext(Movie m) {
        upNext.add(m);
    }

    public void watchNext() {
        if (!upNext.isEmpty()) {
            Movie m = upNext.poll();
            watchHistory.push(m);
            watchedGenres.add(m.genre);
            System.out.println("Watching: " + m);
        }
    }

    public void showRecommendations() {
        System.out.println("=== Recommendations Based on Your Watched Genres ===");
        for (Movie m : allMovies) {
            if (watchedGenres.contains(m.genre) && !watchHistory.contains(m)) {
                System.out.println(m);
            }
        }
    }

    public void showWatchHistory() {
        System.out.println("=== Watch History ===");
        for (Movie m : watchHistory) System.out.println(m);
    }

    public static void main(String[] args) {
        StreamingApp app = new StreamingApp();

        Movie m1 = new Movie("Inception", "Sci-Fi");
        Movie m2 = new Movie("Titanic", "Romance");
        Movie m3 = new Movie("Interstellar", "Sci-Fi");
        Movie m4 = new Movie("La La Land", "Romance");
        Movie m5 = new Movie("Avengers", "Action");

        app.addMovie(m1);
        app.addMovie(m2);
        app.addMovie(m3);
        app.addMovie(m4);
        app.addMovie(m5);

        app.addToUpNext(m1);
        app.addToUpNext(m2);
        app.addToUpNext(m5);

        app.watchNext();
        app.watchNext();

        app.showWatchHistory();
        app.showRecommendations();
    }
}
