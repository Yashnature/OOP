public class UserValidation {

    public static boolean isValidAge(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput);
            return age >= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidAge("20"));
        System.out.println(isValidAge("15"));
        System.out.println(isValidAge("abc"));
        System.out.println(isValidAge("18"));
    }
}
