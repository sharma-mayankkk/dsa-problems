package STRIVERaTOz.BinarySearching.DArray;

import java.util.Arrays;

public class array_06 {
    public static int firstOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    public static int lastOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    public static int[] findOccurrence(int[] arr, int x) {
        int first = firstOccurrence(arr, x);
        if (first == -1) return new int[]{-1, -1};
        int last = lastOccurrence(arr, x);
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(findOccurrence(arr, 8)));
    }
}
