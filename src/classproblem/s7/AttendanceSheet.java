
package classproblem.s7;

public class AttendanceSheet {

    private String[] students;
    private int count;

    // Constructor
    public AttendanceSheet(int maxStudents) {
        students = new String[maxStudents];
        count = 0;
    }

    // Mark a student present
    public void markPresent(String name) {

        // Check if student is already present
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return;
            }
        }

        // Add new student
        if (count < students.length) {
            students[count] = name;
            count++;
        }
    }

    // Return number of present students
    public int getPresentCount() {
        return count;
    }

    // Check whether a student is present
    public boolean isPresent(String name) {

        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count = " + sheet.getPresentCount());
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
    }
}
