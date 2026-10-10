
        package s10;

import java.util.Scanner;

class Student {
    String name;
    int[] marks = new int[3];

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    void calculateResult() {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        double average = sum / 3.0;
        char grade;

        if (average >= 75) {
            grade = 'B';
        } else if (average >= 60) {
            grade = 'C';
        } else if (average >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(), average, grade);
    }
}

public class result {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String name = sc.next();
            int[] marks = new int[3];

            for (int i = 0; i < 3; i++) {
                marks[i] = sc.nextInt();
            }

            Student s = new Student(name, marks);
            s.calculateResult();
        }

        sc.close();
    }
}
