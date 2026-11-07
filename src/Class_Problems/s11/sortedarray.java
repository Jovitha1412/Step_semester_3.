package Class_Problems.s11;

import java.util.Arrays;

public class sortedarray {

    public static int[] pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {

        int[] nums1 = {-4, -1, 0, 3, 5, 9};
        int target1 = 4;

        int[] nums2 = {1, 2, 3};
        int target2 = 100;

        int[] result1 = pairSumSorted(nums1, target1);
        int[] result2 = pairSumSorted(nums2, target2);

        if (result1.length > 0) {
            System.out.println("(" + result1[0] + ", " + result1[1] + ")");
        } else {
            System.out.println("Not Found");
        }

        if (result2.length > 0) {
            System.out.println("(" + result2[0] + ", " + result2[1] + ")");
        } else {
            System.out.println("Not Found");
        }
    }
}