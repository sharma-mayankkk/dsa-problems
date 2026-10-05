package LEETCODE;

//Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.
public class leetCode_137 {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int i : nums) {
            ones = (ones ^ i) & (~twos);
            twos = (twos ^ i) & (~ones);
        }

        return ones;
    }
}
