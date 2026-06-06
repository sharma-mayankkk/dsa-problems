package LEETCODE;

//Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
//Return the minimized largest sum of the split.
//A subarray is a contiguous part of the array.
public class leetCode_410 {
    public static boolean isValid(int[] arr, int k, int mid) {
        int count = 1;
        int num = 0;

        for (int i : arr) {
            if (i + num <= mid) {
                num += i;
            } else {
                count++;
                if (count > k || i > mid) {
                    return false;
                } else {
                    num = i;
                }
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        if (nums.length < k || nums.length == 0) return -1;

        int low = 0, high = 0;

        for (int i : nums) {
            low = Math.max(i, low);
        }
        for (int i : nums) {
            high += i;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(nums, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
