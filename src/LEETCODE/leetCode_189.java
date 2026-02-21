package LEETCODE;

//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
public class leetCode_189 {
    public void reverseArr(int[] arr, int si, int ei) {
        while (si < ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }

    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverseArr(nums, 0, n - 1);
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, n - 1);

    }

    public static void main(String[] args) {

    }
}
