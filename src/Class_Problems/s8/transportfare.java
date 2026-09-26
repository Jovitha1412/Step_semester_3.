
package Class_Problems.s8;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class transportfare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, TransportFactory> transports = new HashMap<>();

        transports.put("BUS", (distance, factor) ->
                new Bus(distance));

        transports.put("TRAIN", (distance, factor) ->
                new Train(distance));

        transports.put("METRO", (distance, factor) ->
                new Metro(distance, factor));

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            double peakHourFactor = 1.0;

            if (type.equals("METRO")) {
                peakHourFactor = sc.nextDouble();
            }

            Transport transport = transports.get(type)
                    .create(distance, peakHourFactor);

            double fare = transport.calculateFare();
            grandTotal += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }

    interface TransportFactory {
        Transport create(double distance, double factor);
    }

    static abstract class Transport {
        double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        abstract double calculateFare();
    }

    static class Bus extends Transport {
        Bus(double distance) {
            super(distance);
        }

        double calculateFare() {
            return Math.min(2 + 0.10 * distance, 10);
        }
    }

    static class Train extends Transport {
        Train(double distance) {
            super(distance);
        }

        double calculateFare() {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro extends Transport {
        double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        double calculateFare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }
}
