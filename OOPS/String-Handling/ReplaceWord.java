public class ReplaceWord {
    public static void main(String[] args) {
        String sentence = "Java is fun";
        String oldWord = "fun";
        String newWord = "powerful";
        String result = "";
        for (String word : sentence.split(" ")) {
            if (word.equals(oldWord))
                result += newWord + " ";
            else
                result += word + " ";
        }
        System.out.println("Modified Sentence: " + result.trim());
    }
}