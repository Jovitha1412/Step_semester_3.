
package Class_Problems.s8;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class examgrader {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Function<String[], Question>> graders =
                new HashMap<>();

        graders.put("MCQ", data -> new MCQ(
                data[0], data[1], Double.parseDouble(data[2])));

        graders.put("TF", data -> new TF(
                data[0], data[1], Double.parseDouble(data[2])));

        graders.put("ESSAY", data -> new Essay(
                data[0], data[1], Double.parseDouble(data[2])));

        int n = Integer.parseInt(sc.nextLine().trim());
        double totalScore = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            Matcher matcher = Pattern.compile("\"([^\"]*)\"|(\\S+)")
                    .matcher(line);

            String[] fields = new String[5];
            int count = 0;

            while (matcher.find()) {
                fields[count++] = matcher.group(1) != null
                        ? matcher.group(1) : matcher.group(2);
            }

            String type = fields[0].toUpperCase();

            String[] data = {
                    fields[2], fields[3], fields[4]
            };

            Question question = graders.get(type).apply(data);
            double score = question.calculateScore();

            totalScore += score;

            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }

    static abstract class Question {
        String correctAnswer;
        String studentAnswer;
        double points;

        Question(String correctAnswer, String studentAnswer,
                 double points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double calculateScore();
    }

    static class MCQ extends Question {
        MCQ(String correctAnswer, String studentAnswer,
            double points) {
            super(correctAnswer, studentAnswer, points);
        }

        double calculateScore() {
            if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
                return points;
            }
            return 0;
        }
    }

    static class TF extends Question {
        TF(String correctAnswer, String studentAnswer,
           double points) {
            super(correctAnswer, studentAnswer, points);
        }

        double calculateScore() {
            if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
                return points;
            }
            return 0;
        }
    }

    static class Essay extends Question {
        Essay(String correctAnswer, String studentAnswer,
              double points) {
            super(correctAnswer, studentAnswer, points);
        }

        double calculateScore() {
            String[] keywords = correctAnswer.split(",");
            int matched = 0;

            String answer = studentAnswer.toLowerCase();

            for (String keyword : keywords) {
                if (answer.contains(keyword.trim().toLowerCase())) {
                    matched++;
                }
            }

            if (matched == keywords.length) {
                return points;
            } else if (matched >= 2) {
                return points * 0.75;
            } else if (matched == 1) {
                return points * 0.50;
            }

            return 0;
        }
    }
}
