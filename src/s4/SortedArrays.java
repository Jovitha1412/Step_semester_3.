package s4;

public class SortedArrays {

    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }

            k++;
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {

        SortedArrays obj = new SortedArrays();

        int[] arr1 = {2, 4, 6};
        int[] arr2 = {8, 10, 12};

        int[] result = obj.mergeSortedArrays(arr1, arr2);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}