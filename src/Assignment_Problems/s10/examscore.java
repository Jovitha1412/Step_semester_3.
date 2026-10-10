package Assignment_Problems.s10;

public class examscore {

    public static int countInBand(int[] scores, int low, int high) {
        int left = lowerBound(scores, low);
        int right = upperBound(scores, high);
        return right - left;
    }

    static int lowerBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] < x)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    static int upperBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] <= x)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
    }
}