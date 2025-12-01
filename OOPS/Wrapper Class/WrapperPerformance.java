import java.util.ArrayList;

public class WrapperPerformance {

    public static void main(String[] args) {
        int size = 1_000_000;

        ArrayList<Integer> list = new ArrayList<>(size);
        long startList = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long sumList = 0;
        for (int num : list) {
            sumList += num;
        }
        long endList = System.currentTimeMillis();

        int[] array = new int[size];
        long startArray = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        long sumArray = 0;
        for (int num : array) {
            sumArray += num;
        }
        long endArray = System.currentTimeMillis();

        System.out.println("ArrayList sum: " + sumList + ", Time: " + (endList - startList) + " ms");
        System.out.println("int[] sum: " + sumArray + ", Time: " + (endArray - startArray) + " ms");
    }
}
