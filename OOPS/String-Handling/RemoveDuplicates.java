public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "programming";
        String result = "";
        for (char ch : str.toCharArray()) {
            if (result.indexOf(ch) == -1)
                result += ch;
        }
        System.out.println("Modified String: " + result);
    }
}