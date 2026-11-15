
package Assignment_Problemss12;

import java.util.Scanner;

class Student {
    private String name;
    private int a, b, c;

    Student(String name) {
        this.name = name;
    }

    boolean setMarks(int a, int b, int c) {
        if (a < 0 || a > 100 ||
                b < 0 || b > 100 ||
                c < 0 || c > 100) {
            return false;
        }

        this.a = a;
        this.b = b;
        this.c = c;
        return true;
    }

    int getTotal() {
        return a + b + c;
    }

    double getAverage() {
        return getTotal() / 3.0;
    }

    String getGrade() {
        double avg = getAverage();

        if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 40) return "D";
        else return "F";
    }

    String getName() {
        return name;
    }

    void display() {
        System.out.printf("%s total=%d avg=%.2f grade=%s%n",
                name, getTotal(), getAverage(), getGrade());
    }
}

public class reportcard {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] students = new Student[n];
        int count = 0;
        int passes = 0;

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Student s = new Student(name);

            if (s.setMarks(a, b, c)) {
                students[count++] = s;
                if (s.getAverage() >= 40) {
                    passes++;
                }
            } else {
                System.out.println(name +
                        " skipped: marks must be 0 to 100");
            }
        }

        // Bubble Sort
        int passesCount = 0;

        for (int i = 0; i < count - 1; i++) {
            boolean swapped = false;
            passesCount++;

            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].getTotal() <
                        students[j + 1].getTotal()) {

                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        // Display ranked students
        for (int i = 0; i < count; i++) {
            System.out.print((i + 1) + ". ");
            students[i].display();
        }

        System.out.println("Sorted in " + passesCount + " passes");
        System.out.println("Number of passes: " + passes);

        sc.close();
    }
}
