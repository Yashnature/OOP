import java.util.*;

public class FactorialRecursive {

    public static int takeInput(Scanner sc) {
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void displayResult(int n, long result) {
        System.out.println("Factorial of " + n + " is: " + result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = takeInput(sc);
        long result = factorial(num);
        displayResult(num, result);
    }
}
