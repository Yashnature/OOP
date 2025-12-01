import java.util.*;

public class PasswordValidatorDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.println("Password: " + password + " → Strong? " + SecurityUtils.isStrongPassword(password));
        sc.close();
    }
}

interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
