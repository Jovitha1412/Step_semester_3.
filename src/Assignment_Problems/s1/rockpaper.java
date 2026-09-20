package Assignment_Problems.s1;

import java.util.Scanner;
import java.util.Random;

public class rockpaper {

    // Method to decide the winner
    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int n = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        // Play 5 rounds
        for (int i = 0; i < n; i++) {

            System.out.println("\nRound " + (i + 1));
            System.out.print("Enter your move (Rock/Paper/Scissors): ");

            String playerMove = sc.nextLine();

            // Generate computer move randomly
            String computerMove = moves[random.nextInt(3)];

            // Find result
            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            System.out.println("Computer Move: " + computerMove);
            System.out.println("Result: " + result);

            // Count results
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        // Summary table
        System.out.println("\n========== FINAL SUMMARY ==========");
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "     | "
                    + playerMoves[i] + "       | "
                    + computerMoves[i] + "       | "
                    + results[i]);
        }

        // Win percentage
        double winPercentage = (wins * 100.0) / n;

        System.out.println("\n========== SCOREBOARD ==========");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%\n", winPercentage);

        sc.close();
    }
}