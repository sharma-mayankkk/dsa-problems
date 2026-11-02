package STRIVERaTOz.SlidingWindow_TwoPointers.CountingSubarrOrSubstringProb;
//Given an array nums and an integer k. An array is called nice if and only if it contains k odd numbers. Find the number of nice subarrays in the given array nums.
//
//A subarray is continuous part of the array.
//
//Example 1:
//Input : nums = [1, 1, 2, 1, 1] , k = 3
//
//Output : 2
//
//Explanation : The subarrays with three odd numbers are
//
//[1, 1, 2, 1]
//
//[1, 2, 1, 1]
public class CountNiceSubarrays {
    public static int count(int[] arr, int k) {
        if (k<0) return 0;
        int l = 0, r = 0, sum = 0, count = 0;

        while (r < arr.length) {
            sum += arr[r]%2;
            while (sum > k) {
                sum = sum - (arr[l]%2);
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
    public static int countNiceSubarrays(int[] arr, int k){
        return count(arr,k) - count(arr,k-1);
    }
    public static void main(String[] args) {

    }
}
