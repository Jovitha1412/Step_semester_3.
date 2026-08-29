package Assignment_Problems.s1;

public class TrafficSignalStreakAnalyzer {

    public static void main(String[] args) {
        String signalLog = "RGGGGYRR";

        findLongestStreak(signalLog);
    }

    static void findLongestStreak(String signalLog) {

        int currentStreak = 1;
        int longestStreak = 1;
        char longestColor = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }

            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestColor
                + "' repeated " + longestStreak + " times");
    }
}