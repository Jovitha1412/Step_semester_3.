package classproblem.s6;

public class Student {

    // Instance fields
    String name;
    double attendance;

    // Static fields
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor
    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        // Creating two Student objects
        Student s1 = new Student("Ravi", 85.5);
        Student s2 = new Student("Anitha", 90.0);

        // Calling static method through class name
        Student.printCollegeInfo();
    }
}