package Assignment_Problems.s6;

public class HallTicket {

    String studentName;
    int seatNumber;

    // Constructor
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {

        // Create first HallTicket object
        HallTicket priya = new HallTicket("Priya", 0);

        // Second variable points to the same object
        HallTicket copy = priya;

        // Change seat number through second variable
        copy.seatNumber = 45;

        // Print value through first variable
        System.out.println("Priya's seatNumber (via first variable):");
        System.out.println(priya.seatNumber);

        // Check if both variables refer to the same object
        System.out.println("copy == priya: " + (copy == priya));

        // Create a separate object with same values
        HallTicket separate = new HallTicket("Priya", 45);

        // Check if separate object is the same object
        System.out.println("separate == priya: " + (separate == priya));
    }
}