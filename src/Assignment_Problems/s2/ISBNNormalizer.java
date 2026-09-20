package Assignment_Problems.s2;

import java.util.Scanner;

public class ISBNNormalizer {

    public static String normalizeCode(String raw) {

        // Remove leading and trailing spaces
        String code = raw.trim();

        // Convert only first 3 characters to uppercase
        if (code.length() >= 3) {
            code = code.substring(0, 3).toUpperCase()
                    + code.substring(3);
        }

        return code;
    }

    public static String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: Wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: Non-letter publisher code";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: Non-digit body";
            }
        }

        // Extract parts
        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        // Build formatted output
        StringBuilder result = new StringBuilder();

        result.append("[")
                .append(publisher)
                .append("] YEAR: ")
                .append(year)
                .append(" | CATALOG: ")
                .append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter ISBN-style code:");
        String raw = sc.nextLine();

        String normalized = normalizeCode(raw);

        String result = validateAndFormat(normalized);

        System.out.println(result);

        sc.close();
    }
}