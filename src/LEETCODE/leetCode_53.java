package LEETCODE;

//Given an integer array nums, find the subarray with the largest sum, and return its sum.
public class leetCode_53 {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
