package STRIVERaTOz.BinarySearching.DDArray;

public class array_03 {
    public static int findMax(int[][] mat, int n, int col) {
        int max = -1;
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                index = i;
            }
        }
        return index;
    }

    public static int[] findPeak(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRowIndex = findMax(arr, n, mid);
            int left = mid - 1 >= 0 ? arr[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < m ? arr[maxRowIndex][mid + 1] : -1;

            if (arr[maxRowIndex][mid] > left && arr[maxRowIndex][mid] > right) {
                return new int[]{maxRowIndex, mid};
            } else if (arr[maxRowIndex][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

    }
}
