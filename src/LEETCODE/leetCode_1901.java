package LEETCODE;
//A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
//
//Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
//
//You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
//
//You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

public class leetCode_1901 {
    public static int findMax(int[][] arr, int n, int col) {
        int max = -1;
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i][col] > max) {
                max = arr[i][col];
                index = i;
            }
        }
        return index;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRowIndex = findMax(mat, n, mid);

            int left = mid - 1 >= 0 ? mat[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRowIndex][mid + 1] : -1;

            if (mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right) {
                return new int[]{maxRowIndex, mid};
            } else if (mat[maxRowIndex][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return new int[]{-1, -1};
    }
}
