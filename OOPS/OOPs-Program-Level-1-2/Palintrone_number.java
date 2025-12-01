public class Palintrone_number {
    public static void main(String[] args) {
        String text = "Yash";
        int left = 0;
        int right = text.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }
    }
}
