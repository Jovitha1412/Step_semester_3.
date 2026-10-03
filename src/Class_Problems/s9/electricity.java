package Class_Problems.s9;

import java.util.Scanner;

abstract class ElectricityConnection {
    int units;

    ElectricityConnection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends ElectricityConnection {
    Home(int units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        } else {
            return (100 * 5) + ((units - 100) * 7);
        }
    }
}

class Shop extends ElectricityConnection {
    Shop(int units) {
        super(units);
    }

    double calculateBill() {
        return (units * 8) + 100;
    }
}

class Factory extends ElectricityConnection {
    Factory(int units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6, 1000);
    }
}

public class electricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();

            ElectricityConnection connection = null;

            switch (type) {
                case "HOME":
                    connection = new Home(units);
                    break;

                case "SHOP":
                    connection = new Shop(units);
                    break;

                case "FACTORY":
                    connection = new Factory(units);
                    break;
            }

            if (connection != null) {
                double bill = connection.calculateBill();
                total += bill;

                System.out.printf("%s: %.2f%n", type, bill);
            }
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}