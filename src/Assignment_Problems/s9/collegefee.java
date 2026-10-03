package Assignment_Problems.s9;

import java.util.Scanner;

public class collegefee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            double fee = 0;

            switch (type) {
                case "DAY_SCHOLAR":
                    fee = 4000 + 1200;
                    break;

                case "HOSTELLER":
                    fee = 4000 + 6000;
                    break;

                case "SCHOLAR":
                    fee = 2000 + 1200;
                    break;
            }

            total += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", total);

        sc.close();
    }
}