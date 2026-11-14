package Assignment_Problems.s12;

import java.util.Scanner;

class Staff {
    protected String name;
    protected double baseSalary;

    public Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return 0.0;
    }

    public String getType() {
        return "Staff";
    }

    public double getTotalSalary() {
        return baseSalary + getBonus();
    }
}

class Teacher extends Staff {
    public Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 5000.0;
    }

    @Override
    public String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    public LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 2000.0;
    }

    @Override
    public String getType() {
        return "LabAssistant";
    }
}

public class campusstaff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        Staff[] staffMembers = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double baseSalary = scanner.nextDouble();

            if (type.equals("Teacher")) {
                staffMembers[i] = new Teacher(name, baseSalary);
            } else if (type.equals("LabAssistant")) {
                staffMembers[i] = new LabAssistant(name, baseSalary);
            } else {
                staffMembers[i] = new Staff(name, baseSalary);
            }
        }

        double grandTotal = 0.0;

        for (Staff member : staffMembers) {
            double bonus = member.getBonus();
            double total = member.getTotalSalary();
            grandTotal += total;

            System.out.println(
                    member.name + " (" + member.getType() + "): base " + member.baseSalary +
                            ", bonus " + bonus + ", total " + total
            );
        }

        System.out.println("Grand Total Salary: " + grandTotal);
        scanner.close();
    }
}