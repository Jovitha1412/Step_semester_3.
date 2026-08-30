package s2;

public class WordReversalEncoder {

    public String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder reversed = new StringBuilder(word);
            result.append(reversed.reverse()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        WordReversalEncoder obj = new WordReversalEncoder();

        String sentence = "hello world";

        System.out.println(obj.reverseEachWord(sentence));
    }
}