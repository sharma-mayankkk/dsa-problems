package LEETCODE;

//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//Example 1:
//
//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
public class leetCode_1004 {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, maxLen = 0, zeroes = 0;

        while (r < nums.length) {
            if (nums[r] == 0) zeroes++;
            if (zeroes > k) {
                if (nums[l] == 0) zeroes--;
                l++;
            }
            if (zeroes <= k) {
                int len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }

            r++;
        }
        return maxLen;
    }

}
