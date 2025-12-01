import java.util.ArrayList;
import java.util.List;

public class StudentMarksReport {

    public static void main(String[] args) {
        Object[] marks = {"85", 95, Integer.valueOf(88), "null", "abc"};
        List<Integer> validMarks = new ArrayList<>();

        for (Object mark : marks) {
            if (mark == null) continue;
            try {
                if (mark instanceof String) {
                    String str = (String) mark;
                    if (!str.equalsIgnoreCase("null")) {
                        validMarks.add(Integer.parseInt(str));
                    }
                } else if (mark instanceof Integer) {
                    validMarks.add((Integer) mark);
                }
            } catch (NumberFormatException e) {
            }
        }

        int sum = 0;
        for (Integer m : validMarks) {
            sum += m;
        }
        double average = validMarks.isEmpty() ? 0 : sum / (double) validMarks.size();

        System.out.println("Valid marks: " + validMarks);
        System.out.println("Average: " + average);
    }
}
