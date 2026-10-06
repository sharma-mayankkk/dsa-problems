package LEETCODE;
//Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
//
//You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
public class leetCode_260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }

        int mask = ((xor) & (-xor));
        int group1 = 0, group2 = 0;

        for (int i : nums) {
            if ((i & mask) == 0) {
                group1 ^= i;
            } else group2 ^= i;
        }

        return new int[]{group1, group2};
    }
}
