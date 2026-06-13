package CODING_NINJA;

//Problem statement
//You are given a row-wise sorted matrix 'mat' of size m x n where 'm' and 'n' are the numbers of rows and columns of the matrix, respectively.
//Your task is to find and return the median of the matrix.
//Note:
//'m' and 'n' will always be odd.
public class Median_in_sorted_mat {
    public static int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1, ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int countLess(int[][] mat, int mid) {
        int count = 0;
        for (int[] i : mat) {
            count += upperBound(i, mid);
        }

        return count;
    }

    public static int findMedian(int matrix[][], int m, int n) {
        // Write your code here
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int[] ints : matrix) {
            low = Math.min(low, ints[0]);
            high = Math.max(high, ints[n - 1]);
        }

        int req = n * m / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countLess(matrix, mid);

            if (count <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
