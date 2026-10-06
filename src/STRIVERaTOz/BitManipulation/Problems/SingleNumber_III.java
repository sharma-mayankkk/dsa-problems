package STRIVERaTOz.BitManipulation.Problems;

import java.util.Arrays;

//Given an array nums of length n, every integer in the array appears twice except for two integers. Identify and return the two integers that appear only once in the array. Return the two numbers in ascending order.
//
//For example, if nums = [1, 2, 1, 3, 5, 2], the correct answer is [3, 5], not [5, 3].
public class SingleNumber_III {
    public static int[] singleNumberIII(int[] arr) {
        int xor = 0;
        for (int i : arr) {
            xor ^= i;
        }

        //create a mask
        int mask = ((xor) & (-xor));
        int group1 = 0;
        int group2 = 0;

        for (int i : arr) {
            if ((i & mask) == 0) {
                group1 ^= i;
            } else group2 ^= i;
        }

        return new int[]{group1, group2};
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,4,5,4,6};
        System.out.println(Arrays.toString(singleNumberIII(arr)));
    }
}
