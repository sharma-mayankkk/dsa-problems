package STRIVERaTOz.BinarySearching.DDArray;

//Find row with maximum 1's
public class array_00 {
    //BruteForce approach:
    public static int findRowWithMax1(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int index = -1, maxCount = -1;
        for (int i = 0; i < m; i++) {
            int currRowCount = 0;
            for (int j = 0; j < n; j++) {
                currRowCount += arr[i][j];
            }
            if (currRowCount > maxCount) {
                maxCount = currRowCount;
                index = i;
            }
        }
        return index;
    }

    //with binary search:
    public static int findLowerBound(int[] arr, int k) {
        int low = 0, high = arr.length-1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int findRowWithMax1BS(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int index = -1, maxCount = -1;
        for (int i = 0; i < m; i++) {
            int countOnes = n - findLowerBound(arr[i], 1);
            if (countOnes > maxCount) {
                maxCount = countOnes;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 1},
                {0, 1, 1, 1}
        };
        System.out.println(findRowWithMax1BS(matrix));
    }
}
