package Assignment_Problems.s6;

public class employeecompany {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    public employeecompany(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    // Static method
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        employeecompany e1 = new employeecompany("Priya", 50000);
        employeecompany e2 = new employeecompany("Arjun", 45000);
        employeecompany e3 = new employeecompany("Divya", 55000);

        employeecompany.printCompanyInfo();
    }
}