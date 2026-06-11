package STRIVERaTOz.BinarySearching.DDArray;

import java.util.Arrays;

//Search in a row and column-wise sorted matrix
//Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. The elements of each row and each column are sorted in non-decreasing order. But, the first element of a row is not necessarily greater than the last element of the previous row (if it exists). You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.
public class array_02 {
    public static int[] searchMatrixII(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0, col = m-1;

        while(row<n && col>=0){
            if(matrix[row][col]==target){
                return new int[]{row,col};
            }else if(matrix[row][col]<target){
                row ++;
            }else{
                col--;
            }
        }
        return  new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[][] mat ={{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};

        System.out.println(Arrays.toString(searchMatrixII(mat, 20)));
    }
}
