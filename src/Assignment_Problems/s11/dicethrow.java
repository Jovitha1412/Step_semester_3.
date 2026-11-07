package Assignment_Problems.s11;

import java.util.Arrays;

public class dicethrow {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int v : rolls) {
            count[v]++;
        }

        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + " ");
        }
        System.out.println();

        int[] sorted = new int[rolls.length];
        int index = 0;

        for (int v = 1; v <= 6; v++) {
            for (int j = 0; j < count[v]; j++) {
                sorted[index++] = v;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};

        int[] result = diceSort(rolls);

        System.out.println("Sorted: " + Arrays.toString(result));
    }
}