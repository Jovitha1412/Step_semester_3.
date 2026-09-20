package Assignment_Problems.s2;

import java.util.Scanner;

public class wordrev {

    public static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder reversed = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reversed.append(word.charAt(i));
            }

            result.append(reversed).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        String output = reverseEachWord(sentence);

        System.out.println("Output: " + output);

        sc.close();
    }
}