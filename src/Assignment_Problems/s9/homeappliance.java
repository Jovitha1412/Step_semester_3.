package Assignment_Problems.s9;

import java.util.Scanner;

public class homeappliance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String appliance = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            String mode = "";
            if (sc.hasNextLine()) {
                // Read optional SAVER from the current input line
                String remaining = sc.nextLine().trim();
                mode = remaining.toUpperCase();
            }

            double power = 0;

            switch (appliance) {
                case "FRIDGE":
                    power = 150;
                    break;
                case "AC":
                    power = 1500;
                    break;
                case "TV":
                    power = 100;
                    break;
                case "WASHER":
                    power = 500;
                    break;
            }

            if (mode.equals("SAVER") &&
                    !appliance.equals("AC") &&
                    !appliance.equals("WASHER")) {
                System.out.println(appliance + ": saver mode not supported");
                continue;
            }

            double units = (power * hours) / 1000;

            if (mode.equals("SAVER")) {
                units = units * 0.75;
            }

            double cost = units * 8;
            total += cost;

            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                    appliance, units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", total);

        sc.close();
    }
}