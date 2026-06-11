package STRIVERaTOz.BinarySearching.DDArray;

//Search in a sorted 2D matrix:
//Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. The elements of each row are sorted in non-decreasing order. Moreover, the first element of a row is greater than the last element of the previous row (if it exists). You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.
public class array_01 {
    public static boolean BSin2dMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = (n * m) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m, col = mid % m;

            if (mat[row][col] == target) {
                return true;
            } else if (mat[row][col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat ={{1, 3, 5, 7},
                    {10, 11, 16, 20},
                    {23, 30, 34, 60}};

        System.out.println(BSin2dMatrix(mat,20));
    }
}
