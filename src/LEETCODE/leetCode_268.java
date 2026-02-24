package LEETCODE;
//PS:Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
//Beats 100% with most optimal solution:
public class leetCode_268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }
        for (int i : nums) {
            xor2 ^= i;
        }
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {

    }
}
