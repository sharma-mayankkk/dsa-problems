package LEETCODE;

//Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
//
//A subarray is a contiguous part of the array.

//Example 1:
//
//Input: nums = [1,0,1,0,1], goal = 2
//Output: 4
public class leetCode_930 {
    public static int count(int[] arr, int k) {
        if (k < 0) return 0;
        int l = 0, r = 0, sum = 0, count = 0;

        while (r < arr.length) {
            sum += arr[r];
            while (sum > k) {
                sum = sum - arr[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return count(nums, goal) - count(nums, goal - 1);
    }
}
