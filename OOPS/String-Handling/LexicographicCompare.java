public class LexicographicCompare {
    public static void main(String[] args) {
        String s1 = "apple", s2 = "banana";
        int minLen = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) < s2.charAt(i))
                    System.out.println(s1 + " comes before " + s2);
                else
                    System.out.println(s2 + " comes before " + s1);
                return;
            }
        }
        if (s1.length() == s2.length())
            System.out.println("Strings are equal");
        else if (s1.length() < s2.length())
            System.out.println(s1 + " comes before " + s2);
        else
            System.out.println(s2 + " comes before " + s1);
    }
}