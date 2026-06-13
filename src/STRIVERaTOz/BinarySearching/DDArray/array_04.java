package STRIVERaTOz.BinarySearching.DDArray;

//Find median in row wise sorted matrix:
public class array_04 {

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

    public static int smallerEquals(int[][] mat, int mid) {
        int count = 0;
        for (int[] i : mat) {
            count += upperBound(i, mid);
        }
        return count;
    }

    public static int findMedian(int[][] mat) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        int n = mat.length, m = mat[0].length;

        for (int[] ints : mat) {
            low = Math.min(low, ints[0]);
            high = Math.max(high, ints[m - 1]);
        }

        int required = (n * m) / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = smallerEquals(mat, mid);
            if (count <= required) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };
        System.out.println(findMedian(matrix));
    }
}
