import java.util.*;

public class FeedbackSystem {
    List<String> allFeedbacks = new ArrayList<>();
    Set<String> uniqueFeedbacks = new HashSet<>();
    Queue<String> feedbackQueue = new LinkedList<>();
    Stack<String> recentFeedbacks = new Stack<>();

    public void addFeedback(String feedback) {
        allFeedbacks.add(feedback);
        if (uniqueFeedbacks.add(feedback)) {
            feedbackQueue.add(feedback);
        }
    }

    public void processFeedback() {
        while (!feedbackQueue.isEmpty()) {
            String feedback = feedbackQueue.poll();
            System.out.println("Processing: " + feedback);
            recentFeedbacks.push(feedback);
        }
    }

    public void showRecentFeedbacks(int count) {
        System.out.println("=== Recent Feedbacks ===");
        int start = Math.max(0, recentFeedbacks.size() - count);
        for (int i = start; i < recentFeedbacks.size(); i++) {
            System.out.println(recentFeedbacks.get(i));
        }
    }

    public static void main(String[] args) {
        FeedbackSystem system = new FeedbackSystem();

        system.addFeedback("Great service!");
        system.addFeedback("Loved the product.");
        system.addFeedback("Great service!");
        system.addFeedback("Could improve delivery time.");

        system.processFeedback();
        system.showRecentFeedbacks(3);
    }
}
