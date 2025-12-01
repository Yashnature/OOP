import java.util.*;
public class ExamResults {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> subjects = new HashMap<>();
        subjects.put("Math", Map.of("Aman", 95, "Riya", 88, "Sam", 76));
        subjects.put("Science", Map.of("Aman", 78, "Riya", 92, "Sam", 85));
        subjects.put("English", Map.of("Aman", 90, "Riya", 85, "Sam", 80));
        for (var subject : subjects.entrySet()) {
            String topName = "";
            int topScore = -1;
            for (var stu : subject.getValue().entrySet()) {
                if (stu.getValue() > topScore) {
                    topScore = stu.getValue(); topName = stu.getKey();
                }
            }
            System.out.println(subject.getKey() + " → " + topName + " (" + topScore + ")");
        }
        for (var subject : subjects.entrySet()) {
            int total = 0;
            for (int m : subject.getValue().values()) total += m;
            System.out.println(subject.getKey() + " avg = " + total / (double) subject.getValue().size());
        }
        for (var subject : subjects.entrySet()) {
            for (int m : subject.getValue().values()) {
                if (m > 90) { System.out.println(subject.getKey()); break; }
            }
        }
    }
}
