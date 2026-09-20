package Class_Problems.s2;

import java.util.Scanner;

public class MaskedPhoneNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.println(maskPhoneNumber(phone));
    }

    static String maskPhoneNumber(String phone) {
        // Check if phone has exactly 10 digits
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder result = new StringBuilder("XXXXXX");
        result.append("-");
        result.append(phone.substring(6));

        return result.toString();
    }
}