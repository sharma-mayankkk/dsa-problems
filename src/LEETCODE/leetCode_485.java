package LEETCODE;

//PS: Given a binary array nums, return the maximum number of consecutive 1's in the array.
public class leetCode_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for (int i : nums) {
            if (i == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
