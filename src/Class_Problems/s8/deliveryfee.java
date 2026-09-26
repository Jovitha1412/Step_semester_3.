
package Class_Problems.s8;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class deliveryfee {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, DeliveryFactory> deliveries = new HashMap<>();
        deliveries.put("STANDARD", (w, d, c) -> new Standard(w, d));
        deliveries.put("EXPRESS", (w, d, c) -> new Express(w, d));
        deliveries.put("INTERNATIONAL", (w, d, c) ->
                new International(w, d, c));

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double customsFee = 0;

            if (type.equals("INTERNATIONAL")) {
                customsFee = sc.nextDouble();
            }

            Delivery delivery = deliveries.get(type)
                    .create(weight, distance, customsFee);

            double fee = delivery.calculateFee();
            grandTotal += fee;

            System.out.printf("%s: %.2f%n", type, fee);
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }

    interface DeliveryFactory {
        Delivery create(double weight, double distance,
                        double customsFee);
    }

    static abstract class Delivery {
        double weight;
        double distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract double calculateFee();
    }

    static class Standard extends Delivery {
        Standard(double weight, double distance) {
            super(weight, distance);
        }

        double calculateFee() {
            return 5 + (0.50 * weight) + (0.10 * distance);
        }
    }

    static class Express extends Delivery {
        Express(double weight, double distance) {
            super(weight, distance);
        }

        double calculateFee() {
            return 15 + (1.00 * weight) + (0.20 * distance);
        }
    }

    static class International extends Delivery {
        double customsFee;

        International(double weight, double distance,
                      double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        double calculateFee() {
            return 25 + (2.50 * weight)
                    + (0.50 * distance) + customsFee;
        }
    }
}
