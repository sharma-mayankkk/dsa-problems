package LEETCODE;

//You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
//
//Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:
//
//0 <= j <= nums[i] and
//i + j < n
//Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.
public class leetCode_45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, l = 0, r = 0;

        while (r < n - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(i + nums[i], farthest);
            }

            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }
}
