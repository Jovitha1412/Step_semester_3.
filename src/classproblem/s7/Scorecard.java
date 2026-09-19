
package classproblem.s7;

public class Scorecard {

    private boolean[] results;
    private final int totalQuestions;
    private int count;

    // Constructor
    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        results = new boolean[totalQuestions];
        count = 0;
    }

    // Record the next answer
    public void recordAnswer(boolean correct) {
        if (count < totalQuestions) {
            results[count] = correct;
            count++;
        } else {
            System.out.println("No more answers can be recorded.");
        }
    }

    // Return only the total score
    public int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score = " + sc.getScore());
    }
}
