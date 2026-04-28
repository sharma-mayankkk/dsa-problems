package LEETCODE;

import java.util.*;

//Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
public class leetCode_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j],
                                nums[k], nums[l]);
                        ans.add(temp);
                        while (k < l && nums[k] == nums[k + 1]) k++;
                        while (k < l && nums[l] == nums[l - 1]) l--;
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else l--;
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {

    }
}
