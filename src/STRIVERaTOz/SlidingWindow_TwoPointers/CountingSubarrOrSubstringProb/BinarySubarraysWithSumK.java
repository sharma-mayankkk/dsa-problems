package STRIVERaTOz.SlidingWindow_TwoPointers.CountingSubarrOrSubstringProb;

public class BinarySubarraysWithSumK {
    public static int count(int[] arr, int k) {
        if (k<0) return 0;
        int l = 0, r = 0, sum = 0, count = 0;

        while (r < arr.length) {
            sum += arr[r];
            while (sum > k) {
                sum = sum - arr[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

    public static int BinSubArrWithSumK(int[] arr, int k){
        return count(arr,k) - count(arr,k-1);
    }

    public static void main(String[] args) {

    }
}
