import java.util.ArrayList;
import java.util.Collections;

public class EmployeeData {

    public static void main(String[] args) {
        int[] ages = {25, 42, 30, 19, 55};
        ArrayList<Integer> ageList = new ArrayList<>();

        for (int age : ages) {
            ageList.add(age);
        }

        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        System.out.println("Employee ages: " + ageList);
        System.out.println("Youngest age: " + youngest);
        System.out.println("Oldest age: " + oldest);
    }
}
