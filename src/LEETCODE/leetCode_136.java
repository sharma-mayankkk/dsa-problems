package LEETCODE;

//PS:Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
public class leetCode_136 {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        return xor;
    }
}
