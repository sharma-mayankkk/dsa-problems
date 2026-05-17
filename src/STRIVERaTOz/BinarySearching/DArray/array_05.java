package STRIVERaTOz.BinarySearching.DArray;

import java.util.Arrays;

//Find first and last occurrence;
public class array_05 {
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int[] firstAndLastOccurrence(int[] arr, int x) {
        int lb = lowerBound(arr, x);
        if (lb == arr.length || arr[lb] != x) return new int[]{-1, -1};
        return new int[]{lb, upperBound(arr, x) - 1};
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(firstAndLastOccurrence(arr, 11)));
    }
}
