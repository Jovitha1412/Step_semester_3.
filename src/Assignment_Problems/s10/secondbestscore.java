package Assignment_Problems.s10;

public class secondbestscore {

    public static int secondHighest(int[] scores) {
        int highest = -1, second = -1;

        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s < highest && s > second) {
                second = s;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] scores = {45, 78, 92, 78, 60};
        System.out.println(secondHighest(scores));
    }
}