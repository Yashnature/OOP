import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRatingsAnalyzer {

    public static void main(String[] args) {
        int[] primitiveRatings = {5, 4, 3, 5};
        ArrayList<Integer> objectRatings = new ArrayList<>();
        objectRatings.add(4);
        objectRatings.add(null);
        objectRatings.add(5);

        List<Integer> allRatings = new ArrayList<>();
        for (int r : primitiveRatings) {
            allRatings.add(r);
        }
        for (Integer r : objectRatings) {
            if (Objects.nonNull(r)) {
                allRatings.add(r);
            }
        }

        double sum = 0;
        for (Integer r : allRatings) {
            sum += r;
        }
        double average = allRatings.isEmpty() ? 0 : sum / allRatings.size();

        System.out.println("All ratings: " + allRatings);
        System.out.println("Average rating: " + average);
    }
}
