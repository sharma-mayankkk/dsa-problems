package LEETCODE;
import java.util.*;
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
public class leetCode_01 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            int moreNeeded = target - nums[i];

            // Check if complement exists
            if(map.containsKey(moreNeeded)) {
                return new int[]{map.get(moreNeeded), i};
            }

            // Store current number and index
            map.put(nums[i], i);
        }

        return new int[]{-1, -1}; // (LeetCode guarantees one solution)
    }
}
