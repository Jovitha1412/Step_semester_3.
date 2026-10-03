package Class_Problems.s9;

import java.util.Scanner;

abstract class Shape {
    abstract double calculateArea();
    abstract String getShapeName();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    String getShapeName() {
        return "CIRCLE";
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    String getShapeName() {
        return "RECTANGLE";
    }
}

class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }

    String getShapeName() {
        return "TRIANGLE";
    }
}

public class gardenplot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next().toUpperCase();
            String owner = sc.next();

            Shape plot = null;

            switch (shape) {
                case "CIRCLE":
                    double radius = sc.nextDouble();
                    plot = new Circle(radius);
                    break;

                case "RECTANGLE":
                    double length = sc.nextDouble();
                    double width = sc.nextDouble();
                    plot = new Rectangle(length, width);
                    break;

                case "TRIANGLE":
                    double base = sc.nextDouble();
                    double height = sc.nextDouble();
                    plot = new Triangle(base, height);
                    break;
            }

            if (plot != null) {
                double area = plot.calculateArea();
                totalArea += area;

                System.out.printf("%s (%s): %.2f%n",
                        owner, plot.getShapeName(), area);
            }
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        sc.close();
    }
}