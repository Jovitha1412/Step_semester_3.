
package Class_Problems.s8;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

public class paymentsystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Function<Double, Payment>> payments = new HashMap<>();
        payments.put("CARD", Card::new);
        payments.put("WALLET", Wallet::new);
        payments.put("BANKTRANSFER", BankTransfer::new);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            Payment payment = payments.get(type).apply(amount);
            double adjustedAmount = payment.calculateAmount();

            grandTotal += adjustedAmount;

            System.out.printf("%s: %.2f%n", type, adjustedAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }

    static abstract class Payment {
        double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract double calculateAmount();
    }

    static class Card extends Payment {
        Card(double amount) {
            super(amount);
        }

        double calculateAmount() {
            return amount * 1.02;
        }
    }

    static class Wallet extends Payment {
        Wallet(double amount) {
            super(amount);
        }

        double calculateAmount() {
            return amount * 1.01;
        }
    }

    static class BankTransfer extends Payment {
        BankTransfer(double amount) {
            super(amount);
        }

        double calculateAmount() {
            return amount;
        }
    }
}
