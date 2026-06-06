package STRIVERaTOz.BinarySearching.BSonAnswers;

//Split Array - Largest Sum
//Problem Statement: Given an integer array ‘A’ of size ‘N’ and an integer ‘K. Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized. Your task is to return the minimized largest sum of the split. A subarray is a contiguous part of the array.
public class array_09 {
    public static boolean isValid(int[] arr, int k, int mid) {
        int count = 1;
        int num = 0;

        for (int i : arr) {
            if (i + num <= mid) {
                num += i;
            } else {
                count++;
                if (count > k || i > mid) {
                    return false;
                } else {
                    num = i;
                }
            }
        }
        return true;
    }

    public static int splitArray(int[] arr, int k) {
        if (arr.length < k || arr.length == 0) return -1;

        int low = 0, high = 0;

        for (int i : arr) {
            low = Math.max(i, low);
        }
        for (int i : arr) {
            high += i;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(arr, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        System.out.println(splitArray(arr, 2));
    }
}
