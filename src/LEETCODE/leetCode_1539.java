package LEETCODE;

//Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
//Return the kth positive integer that is missing from this array.
public class leetCode_1539 {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missingTillMid = arr[mid] - (mid + 1);

            if (missingTillMid < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + k;
    }

    public static void main(String[] args) {

    }
}
