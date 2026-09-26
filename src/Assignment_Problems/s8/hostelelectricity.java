package Assignment_Problems.s8;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.function.BiFunction;

public class hostelelectricity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, BiFunction<Integer, Integer, Room>> rooms = new HashMap<>();
        rooms.put("SINGLE", (units, occupants) -> new SingleRoom(units));
        rooms.put("SHARED", SharedRoom::new);
        rooms.put("AC", (units, occupants) -> new AcRoom(units));

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();
            int occupants = 1;

            if (type.equals("SHARED")) {
                occupants = sc.nextInt();
            }

            Room room = rooms.get(type).apply(units, occupants);
            double bill = room.calculateBill();

            grandTotal += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }

    static abstract class Room {
        int units;

        Room(int units) {
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) {
            super(units);
        }

        double calculateBill() {
            return units * 8;
        }
    }

    static class SharedRoom extends Room {
        int occupants;

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        double calculateBill() {
            return (units * 6.0) / occupants;
        }
    }

    static class AcRoom extends Room {
        AcRoom(int units) {
            super(units);
        }

        double calculateBill() {
            return units * 10 + 20;
        }
    }
}