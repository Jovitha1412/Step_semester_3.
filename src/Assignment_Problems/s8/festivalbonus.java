
package Assignment_Problems.s8;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class festivalbonus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, EmployeeFactory> employees = new HashMap<>();
        employees.put("FULLTIME", FullTime::new);
        employees.put("PARTTIME", PartTime::new);
        employees.put("INTERN", Intern::new);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee = employees.get(type).create(name, salary);

            double bonus = employee.calculateBonus();
            grandTotal += bonus;

            System.out.printf("%s: %.2f%n", employee.name, bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", grandTotal);

        sc.close();
    }

    interface EmployeeFactory {
        Employee create(String name, double salary);
    }

    static abstract class Employee {
        String name;
        double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        abstract double calculateBonus();
    }

    static class FullTime extends Employee {
        FullTime(String name, double salary) {
            super(name, salary);
        }

        double calculateBonus() {
            return salary * 0.10;
        }
    }

    static class PartTime extends Employee {
        PartTime(String name, double salary) {
            super(name, salary);
        }

        double calculateBonus() {
            return salary * 0.05;
        }
    }

    static class Intern extends Employee {
        Intern(String name, double salary) {
            super(name, salary);
        }

        double calculateBonus() {
            return 2000;
        }
    }
}
