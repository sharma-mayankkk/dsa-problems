package STRIVERaTOz.BinarySearching.BSonAnswers;

import java.util.ArrayList;

//Median of 2 sorted arrays
public class array_11 {
    //BruteForce method:
    public static double medianOfTwoSortedArray(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        ArrayList<Integer> arr3 = new ArrayList<>();
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                arr3.add(arr1[i++]);
            } else {
                arr3.add(arr2[j++]);
            }
        }
        while (i < m) {
            arr3.add(arr1[i++]);
        }

        while (j < n) {
            arr3.add(arr2[j++]);
        }

        int size = n + m;
        if (size % 2 == 1) {
            return arr3.get(size / 2);
        }

        return (double) (arr3.get(size / 2) + arr3.get(size / 2 - 1)) / 2;
    }

    //better solution:
    public static double medianOfTwoSortedArray2(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int i = 0, j = 0;
        int n = n1 + n2;
        int index2 = n / 2;
        int index1 = index2 - 1;
        int count = 0;
        int index1Ele = -1, index2Ele = -1;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                if (count == index1) index1Ele = arr1[i];
                if (count == index2) index2Ele = arr1[i];
                count++;
                i++;
            } else {
                if (count == index1) index1Ele = arr2[j];
                if (count == index2) index2Ele = arr2[j];
                count++;
                j++;
            }
        }

        while (i < n1) {
            if (count == index1) index1Ele = arr1[i];
            if (count == index2) index2Ele = arr1[i];
            count++;
            i++;
        }

        while (j < n2) {
            if (count == index1) index1Ele = arr2[j];
            if (count == index2) index2Ele = arr2[j];
            count++;
            j++;
        }

        if (n % 2 == 1) {
            return index2Ele;
        }

        return (double) (index1Ele + index2Ele) / 2;
    }

    //Binary search Approach:
    public static double medianOfTwoSortedArrayBS(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        if (n1 > n2) return medianOfTwoSortedArray(arr2, arr1);

        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;
        int n = n1 + n2;
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MIN_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < n1) r1 = arr1[mid1];
            if (mid2 < n2) r2 = arr2[mid2];
            if (mid1 - 1 >= 0) l1 = arr1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = arr2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l2, l1);
                return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2}, arr2 = {3, 4};
        System.out.println(medianOfTwoSortedArray(arr1, arr2));
    }
}
