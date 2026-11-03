package STRIVERaTOz.SlidingWindow_TwoPointers.CountingSubarrOrSubstringProb;

import java.util.HashMap;
import java.util.Map;

//You are given an integer array nums and an integer k.
//
//Return the number of good subarrays of nums.
//
//A good subarray is defined as a contiguous subarray of nums that contains exactly k distinct integers.
//
//A subarray is a contiguous part of the array.
//
//Example 1:
//Input: nums = [1, 2, 1, 2, 3], k = 2
//
//Output: 7
//
//Explanation: The 7 subarrays with exactly 2 different integers are:
//
//[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
public class SubarraysWithKDifferentInt {
    //BruteForce:
    public static int subArr(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < arr.length; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                if (map.size() == k) {
                    count++;
                } else if (map.size() > k) {
                    break;
                }
            }
        }
        return count;
    }

    //optimal :
    public static int count(int[] arr, int k){
        int l = 0, r=0, count = 0;
        Map<Integer,Integer> map = new HashMap<>();

        while(r<arr.length){
            map.put(arr[r], map.getOrDefault(arr[r],0)+1);
            while(map.size()>k){
                map.put(arr[l], map.getOrDefault(arr[l],0)-1);
                if (map.get(arr[l])==0) map.remove(arr[l]);
                l++;
            }
            count+= r-l+1;
            r++;
        }
        return count;
    }

    public static int subArray(int[] arr, int k){
        return count(arr,k) - count(arr,k-1);
    }
    public static void main(String[] args) {
        System.out.println(subArray(new int[]{1, 2, 1, 2, 3},2));
    }
}
