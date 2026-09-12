package Assignment_Problems.s6;

public class payrollsalary {

    private double basicSalary;
    private double bonus;

    // Constructor
    public payrollsalary(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Negative salary! Starting with 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        bonus = 0;
    }

    // Credit bonus
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus amount must be positive.");
        } else {
            bonus = bonus + amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Deduct tax
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage.");
        } else {
            basicSalary = basicSalary - (basicSalary * percent / 100);
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    // Get net salary
    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        payrollsalary p = new payrollsalary(50000);

        p.creditBonus(5000);

        p.deductTax(10);

        System.out.println("Net salary: Rs " + p.getNetSalary());
    }
}