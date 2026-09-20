package Class_Problems.s5;

import java.util.Arrays;

public class placementdrive {

    String name;
    double cgpa;
    int codingScore;

    public static void main(String[] args) {

        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.8, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }

    static class Candidate implements Comparable<Candidate> {

        String name;
        double cgpa;
        int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && cgpa < 7.5
                    && codingScore >= 60 && codingScore <= 80;
        }

        double getCompositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(),
                    this.getCompositeScore());
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        int count = 0;

        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.cgpa) ||
                    Candidate.isEligible(c.cgpa, c.codingScore)) {
                count++;
            }
        }

        Candidate[] shortlisted = new Candidate[count];
        int index = 0;

        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.cgpa) ||
                    Candidate.isEligible(c.cgpa, c.codingScore)) {
                shortlisted[index++] = c;
            }
        }

        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {
            result += (i + 1) + ". " +
                    shortlisted[i].name + " (" +
                    shortlisted[i].getCompositeScore() + ")";

            if (i < shortlisted.length - 1) {
                result += " | ";
            }
        }

        return result;
    }
}