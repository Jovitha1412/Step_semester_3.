package Assignment_Problems;

public class GuessTheNumber {

    static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {

        int tries = 0;
        boolean guessed = false;

        while (tries < maxTries && !guessed) {

            int guess = guesses[tries];

            if (guess > secretNumber) {
                System.out.print("Too high ");
            } else if (guess < secretNumber) {
                System.out.print("Too low ");
            } else {
                System.out.print("Correct! You guessed it");
                guessed = true;
                break;
            }

            tries++;
        }

        if (!guessed) {
            System.out.print("Out of tries — the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {

        int secretNumber = 40;
        int maxTries = 1;
        int[] guesses = {22, 17, 12};

        guessTheNumber(secretNumber, maxTries, guesses);
    }
}