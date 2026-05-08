package STRIVERaTOz.Array.Hard;

//Maximum Product Subarray in an Array
//Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.
public class array_10 {
    public static int maxSubarrayProduct(int[] arr) {
        int n = arr.length;
        int pre = 1, suf = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suf == 0) suf = 1;

            pre *= arr[i];
            suf *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suf));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4, -1};
        System.out.println(maxSubarrayProduct(arr));
    }
}
