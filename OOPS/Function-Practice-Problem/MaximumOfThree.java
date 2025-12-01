import java.util.*;

public class MaximumOfThree {

    public static int[] takeInput(Scanner sc) {
        int[] numbers = new int[3];
        System.out.print("Enter first number: ");
        numbers[0] = sc.nextInt();
        System.out.print("Enter second number: ");
        numbers[1] = sc.nextInt();
        System.out.print("Enter third number: ");
        numbers[2] = sc.nextInt();
        return numbers;
    }

    public static int findMaximum(int[] numbers) {
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = takeInput(sc);
        int max = findMaximum(numbers);
        System.out.println("The maximum of the three numbers is: " + max);
    }
}
