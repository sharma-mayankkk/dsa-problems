package LEETCODE;

//Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
//
//Return the number of nice sub-arrays.
//
//
//
//Example 1:
//
//Input: nums = [1,1,2,1,1], k = 3
//Output: 2
//Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
public class leetCode_1248 {
    public static int count(int[] arr, int k) {
        if (k < 0) return 0;
        int l = 0, r = 0, sum = 0, count = 0;

        while (r < arr.length) {
            sum += arr[r] % 2;
            while (sum > k) {
                sum = sum - (arr[l] % 2);
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return count(nums, k) - count(nums, k - 1);
    }
}
