package Class_Problems.s1;

import java.util.Scanner;

public class palindromechecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        boolean result1 = isPalindromeIterative(text);
        boolean result2 = isPalindromeRecursive(text);
        boolean result3 = isPalindromeArrayReversal(text);

        System.out.println("Iterative: " +
                (result1 ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (result2 ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (result3 ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }

    // 1. Iterative approach
    public static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // 2. Recursive approach
    public static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // 3. Array reversal approach
    public static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }

        return true;
    }
}