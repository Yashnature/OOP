import java.util.*;

public class EmployeeData {
    public static void main(String[] args) {
        int[] ages = {25, 30, 45, 22, 36, 29};
        ArrayList<Integer> ageList = new ArrayList<>();

        for (int age : ages) {
            ageList.add(Integer.valueOf(age));
        }

        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        System.out.println("Employee Ages: " + ageList);
        System.out.println("Youngest Age: " + youngest);
        System.out.println("Oldest Age: " + oldest);
    }
}
