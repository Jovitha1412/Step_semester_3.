package Assignment_Problems.s9;

import java.util.Scanner;

public class citycab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String cab = sc.next().toUpperCase();
            int distance = sc.nextInt();
            String time = sc.next().toUpperCase();

            double rate = 0;
            double fare = 0;

            switch (cab) {
                case "MINI":
                    rate = 10;
                    break;
                case "SEDAN":
                    rate = 14;
                    break;
                case "SUV":
                    rate = 18;
                    break;
            }

            if (cab.equals("MINI") && time.equals("NIGHT")) {
                System.out.println("MINI: night service not available");
            } else {
                fare = Math.max(distance * rate, 100);

                if (time.equals("NIGHT")) {
                    fare += fare * 0.20;
                }

                total += fare;
                System.out.printf("%s: %.2f%n", cab, fare);
            }
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}