package Assignment_Problems;

public class AtmPinRetry {

    static void atmPinRetry(String correctPin, String[] attempts) {

        int count = 0;
        boolean success = false;

        while (count < 3 && !success) {

            if (attempts[count].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }

            count++;
        }

        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {

        String correctPin = "4821";

        String[] attempts = {"1111", "4821"};

        atmPinRetry(correctPin, attempts);
    }
}