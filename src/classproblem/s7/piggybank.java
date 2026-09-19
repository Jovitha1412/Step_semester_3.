
package classproblem.s7;

public class piggybank {

    private double savings;
    private final String id;

    // Constructor
    public piggybank(String id) {
        this.id = id;
        this.savings = 0;
    }

    // Deposit money
    public void deposit(double amount) {
        savings = savings + amount;
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= savings) {
            savings = savings - amount;
        } else {
            System.out.println("Withdrawal rejected");
        }
    }

    // Check savings
    public double getSavings() {
        return savings;
    }

    // Check ID
    public String getId() {
        return id;
    }

    // Main method
    public static void main(String[] args) {

        piggybank pb = new piggybank("PB-1");

        pb.deposit(100);
        System.out.println("After deposit: savings = " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("After withdrawal: savings = " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("After rejected withdrawal: savings = " + pb.getSavings());
    }
}
