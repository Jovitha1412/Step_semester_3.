package Assignment_Problems.s8;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

public class campusparking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Function<Integer, Vehicle>> vehicles = new HashMap<>();
        vehicles.put("BIKE", Bike::new);
        vehicles.put("CAR", Car::new);
        vehicles.put("TRUCK", Truck::new);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int hours = sc.nextInt();

            Vehicle v = vehicles.get(type).apply(hours);
            double charge = v.calculateCharge();

            grandTotal += charge;

            System.out.printf("%s: %.2f%n", type, charge);
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }

    static abstract class Vehicle {
        int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract double calculateCharge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) {
            super(hours);
        }

        double calculateCharge() {
            return hours * 10;
        }
    }

    static class Car extends Vehicle {
        Car(int hours) {
            super(hours);
        }

        double calculateCharge() {
            return 30 + (hours - 1) * 20;
        }
    }

    static class Truck extends Vehicle {
        Truck(int hours) {
            super(hours);
        }

        double calculateCharge() {
            return Math.max(hours * 50, 100);
        }
    }
}