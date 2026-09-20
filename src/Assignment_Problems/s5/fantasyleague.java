package Assignment_Problems.s5;

import java.util.Arrays;

public class fantasyleague {

    public static class Player implements Comparable<Player> {

        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        public Player(String name, int matchesPlayed,
                      double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Rule for experienced players
        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        // Rule for less experienced players
        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        // Compare players by batting average, highest first
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage,
                    this.battingAverage);
        }
    }

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player player : players) {

            boolean eligible;

            if (player.matchesPlayed >= 10) {
                eligible = Player.isDraftable(player.matchesPlayed);
            } else {
                eligible = Player.isDraftable(
                        player.matchesPlayed,
                        player.injured
                );
            }

            if (eligible) {
                draftable[count] = player;
                count++;
            }
        }

        Player[] result = Arrays.copyOf(draftable, count);

        Arrays.sort(result);

        String output = "";

        for (int i = 0; i < result.length; i++) {

            if (i > 0) {
                output += " | ";
            }

            output += (i + 1) + ". " + result[i].name;
        }

        return output;
    }

    public static void main(String[] args) {

        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}