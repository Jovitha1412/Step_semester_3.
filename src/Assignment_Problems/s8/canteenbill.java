
package Assignment_Problems.s8;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

public class canteenbill {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Function<Double, Customer>> customerTypes = new HashMap<>();
        customerTypes.put("STUDENT", Student::new);
        customerTypes.put("STAFF", Staff::new);
        customerTypes.put("GUEST", Guest::new);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            Customer customer = customerTypes.get(type).apply(amount);

            double finalAmount = customer.calculateFinalAmount();
            grandTotal += finalAmount;

            System.out.printf("%s: %.2f%n", type, finalAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }

    static abstract class Customer {
        double amount;

        Customer(double amount) {
            this.amount = amount;
        }

        abstract double calculateFinalAmount();
    }

    static class Student extends Customer {
        Student(double amount) {
            super(amount);
        }

        double calculateFinalAmount() {
            return amount * 0.90;
        }
    }

    static class Staff extends Customer {
        Staff(double amount) {
            super(amount);
        }

        double calculateFinalAmount() {
            return amount * 0.95;
        }
    }

    static class Guest extends Customer {
        Guest(double amount) {
            super(amount);
        }

        double calculateFinalAmount() {
            return amount + 10;
        }
    }
}
