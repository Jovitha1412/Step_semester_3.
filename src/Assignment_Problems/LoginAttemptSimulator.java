package Assignment_Problems;

import java.util.Scanner;

public class LoginAttemptSimulator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter correct access code: ");
        String correctCode = sc.nextLine();

        System.out.print("Enter number of attempts: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] attempts = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter attempt " + (i + 1) + ": ");
            attempts[i] = sc.nextLine();
        }

        simulateLogin(correctCode, attempts);
    }

    static void simulateLogin(String correctCode, String[] attempts) {

        boolean granted = false;

        for (int i = 0; i < attempts.length; i++) {

            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                granted = true;
                break;
            }
        }

        if (!granted) {
            System.out.println("Access denied — all attempts used");
        }
    }
}