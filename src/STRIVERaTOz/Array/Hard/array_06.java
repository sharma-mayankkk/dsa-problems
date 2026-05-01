package STRIVERaTOz.Array.Hard;

import java.util.Arrays;
//Merge two Sorted Arrays Without Extra Space
public class array_06 {
    //BruteForce approach:(using an extra space)

    public static void mergeArrays(int[] arr1, int m, int[] arr2, int n) {

        int[] arr = new int[m + n];
        int right = 0, left = 0, index = 0;

        while (left < m && right < n) {
            if (arr1[left] <= arr2[right]) {
                arr[index] = arr1[left];
                left++;
            } else {
                arr[index] = arr2[right];
                right++;
            }
            index++;
        }

        while (left < m) {
            arr[index++] = arr1[left++];
        }

        while (right < n) {
            arr[index++] = arr2[right++];
        }

        index = 0;

        //putting all elements back to the original array:
        for (int i = 0; i < m + n; i++) {
            if (i < m) {
                arr1[i] = arr[i];
            } else {
                arr2[i - m] = arr[i];
            }
        }
    }

    //Optimal Solution: TC- O(min(m,n)+O(n log n)+O(m log m):
    public static void mergeArrays2(int[] arr1, int m, int[] arr2, int n) {
        int left = m - 1, right = 0;

        while (left >= 0 && right < n) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;

                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    //second optimal solution:

    //helper function:
    private static void swapIfGreater(int[] arr1, int[] arr2, int index1, int index2) {
        if (arr1[index1] > arr2[index2]) {
            int temp = arr1[index1];
            arr1[index1] = arr2[index2];
            arr2[index2] = temp;
        }
    }

    public static void mergeArrays3(int[] arr1, int m, int[] arr2, int n) {
        int len = m + n;
        int gap = Math.ceilDiv(len, 2);
        while (gap > 0) {

            int left = 0;
            int right = left + gap;
            while (right < len) {
                //both are in different arrays:
                if (left < m && right >= m) {
                    swapIfGreater(arr1, arr2, left, right - m);
                    //both pointer in 2nd array:
                } else if (left >= m) {
                    swapIfGreater(arr2, arr2, left - m, right - m);
                    //both pointer in 1st array:
                } else {
                    swapIfGreater(arr1, arr1, left, right);
                }

                left++;
                right++;
            }
            if (gap == 1) break;
            gap = Math.ceilDiv(gap, 2);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2};
        int[] arr2 = {2, 2, 3};

        int m = 3, n = 3;

        mergeArrays2(arr1, m, arr2, n);

        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }
}
