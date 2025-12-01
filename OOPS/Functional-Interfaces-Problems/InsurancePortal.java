import java.util.regex.*;

interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        if (password.length() < 8) return false;
        Pattern upper = Pattern.compile("[A-Z]");
        Pattern lower = Pattern.compile("[a-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[^a-zA-Z0-9]");
        return upper.matcher(password).find() &&
               lower.matcher(password).find() &&
               digit.matcher(password).find() &&
               special.matcher(password).find();
    }
}

class InsurancePortal {
    public static void main(String[] args) {
        String[] passwords = {
            "Password123!",
            "weakpass",
            "Strong@2025"
        };

        for (String pwd : passwords) {
            if (SecurityUtils.isStrongPassword(pwd)) {
                System.out.println(pwd + " is strong");
            } else {
                System.out.println(pwd + " is weak");
            }
        }
    }
}
