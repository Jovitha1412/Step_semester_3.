package Assignment_Problems.s10;

public class busiestbus {

    public static int busiestRow(int[][] grid) {
        int max = -1, row = 0;

        for (int i = 0; i < grid.length; i++) {
            int total = 0;

            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }

            if (total > max) {
                max = total;
                row = i;
            }
        }

        return row;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
        };

        int row = busiestRow(grid);
        int total = 0;

        for (int x : grid[row]) {
            total += x;
        }

        System.out.println("Row " + row + ", Total " + total);
    }
}