import java.util.Scanner;
public class VotingEligibility {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter age: ");
        int age=s.nextInt();

        if (age>=18) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }