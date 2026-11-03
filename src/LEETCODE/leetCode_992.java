package LEETCODE;

import java.util.HashMap;
import java.util.Map;

//Given an integer array nums and an integer k, return the number of good subarrays of nums.
//
//A good array is an array where the number of different integers in that array is exactly k.
//
//For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
//A subarray is a contiguous part of an array.
public class leetCode_992 {
    public static int count(int[] arr, int k) {
        int l = 0, r = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            while (map.size() > k) {
                map.put(arr[l], map.getOrDefault(arr[l], 0) - 1);
                if (map.get(arr[l]) == 0) map.remove(arr[l]);
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums, k) - count(nums, k - 1);
    }
}
