
package Assignment_Problemss12;

import java.util.Scanner;

public class returndesk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Stack for books
        String[] stack = new String[3];
        int top = -1;

        // Circular Queue for students
        String[] queue = new String[3];
        int front = 0, rear = -1, size = 0;

        System.out.println("Enter commands (comma separated):");

        String input = sc.nextLine();
        String[] commands = input.split(",");

        for (String cmd : commands) {

            cmd = cmd.trim();

            // RETURN operation - Push
            if (cmd.startsWith("RETURN")) {

                String book = cmd.substring(6).trim();

                if (top == 2) {
                    System.out.println(book + " rejected: pile is full");
                } else {
                    stack[++top] = book;
                    System.out.println(book + " placed on pile");
                }
            }

            // WAIT operation - Enqueue
            else if (cmd.startsWith("WAIT")) {

                String student = cmd.substring(4).trim();

                if (size == 3) {
                    System.out.println(student + " rejected: line is full");
                } else {
                    rear = (rear + 1) % 3;
                    queue[rear] = student;
                    size++;

                    System.out.println(student + " joined the line");
                }
            }

            // SHELVE operation - Pop
            else if (cmd.equals("SHELVE")) {

                if (top == -1) {
                    System.out.println("pile is empty");
                } else {
                    System.out.println("shelved " + stack[top]);
                    stack[top] = null;
                    top--;
                }
            }

            // SERVE operation - Dequeue
            else if (cmd.equals("SERVE")) {

                if (size == 0) {
                    System.out.println("no one waiting");
                } else {
                    System.out.println("served " + queue[front]);

                    queue[front] = null;
                    front = (front + 1) % 3;
                    size--;
                }
            }
        }

        sc.close();
    }
}
