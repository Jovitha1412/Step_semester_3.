package Assignment_Problems.s6;

public class Employee {

    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    // Constructor for permanent employee
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for intern
    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    // Print employee profile
    public void printProfile() {
        System.out.println(empId + " | " + empName +
                " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {

        // Permanent employee
        Employee e1 = new Employee("E-101", "Divya", 65000);

        // Intern
        Employee e2 = new Employee("E-102", "Arjun");

        e1.printProfile();
        e2.printProfile();
    }
}