package LEETCODE;

import java.util.*;

//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
public class leetCode_560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int preSum = 0;

        for (int i : nums) {
            preSum += i;
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
