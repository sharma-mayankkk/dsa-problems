package CODING_NINJA;

import java.util.ArrayList;
import java.util.Collections;

//Problem statement
//You are given a starting position for a rat which is stuck in a maze at an initial point (0, 0) (the maze can be thought of as a 2-dimensional plane). The maze would be given in the form of a square matrix of order 'N' * 'N' where the cells with value 0 represent the maze’s blocked locations while value 1 is the open/available path that the rat can take to reach its destination. The rat's destination is at ('N' - 1, 'N' - 1). Your task is to find all the possible paths that the rat can take to reach from source to destination in the maze. The possible directions that it can take to move in the maze are 'U'(up) i.e. (x, y - 1) , 'D'(down) i.e. (x, y + 1) , 'L' (left) i.e. (x - 1, y), 'R' (right) i.e. (x + 1, y).
//
//Note:
//Here, sorted paths mean that the expected output should be in alphabetical order.
//For Example:
//Given a square matrix of size 4*4 (i.e. here 'N' = 4):
//1 0 0 0
//1 1 0 0
//1 1 0 0
//0 1 1 1
//Expected Output:
//DDRDRR DRDDRR
//i.e. Path-1: DDRDRR and Path-2: DRDDRR
//
//The rat can reach the destination at (3, 3) from (0, 0) by two paths, i.e. DRDDRR and DDRDRR when printed in sorted order, we get DDRDRR DRDDRR.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//2 <= N <= 5
//0 <= MATRIX[i][j] <= 1
//
//Where N is the size of the square matrix.
//
//Time Limit: 1sec
//Sample Input 1:
//4
//1 0 0 0
//1 1 0 1
//1 1 0 0
//0 1 1 1
//Sample Output 1:
//DDRDRR DRDDRR
//Explanation For Sample Input 1:
//The rat can reach the destination at (3, 3) from (0, 0) by two paths, i.e. DRDDRR and DDRDRR when printed in sorted order, we get DDRDRR DRDDRR.
//Sample Input 2:
//2
//1 0
//1 0
//Sample Output 2:
//[]
//Explanation For Sample Input 2:
//As no valid path exists in Sample input 2 so we return an empty list.
public class aRatInMaze {
    public static void solve(int[][] arr, int n, int row, int col, String path, ArrayList<String> ans) {

        if (row < 0 || col < 0 || row >= n || col >= n ||
                arr[row][col] == 0 || arr[row][col] == -1) {
            return;
        }

        // Destination
        if (row == n - 1 && col == n - 1) {
            ans.add(path);
            return;
        }

        // Mark visited
        arr[row][col] = -1;

        // Down
        solve(arr, n, row + 1, col, path + "D", ans);

        // Up
        solve(arr, n, row - 1, col, path + "U", ans);

        // Right
        solve(arr, n, row, col + 1, path + "R", ans);

        // Left
        solve(arr, n, row, col - 1, path + "L", ans);

        // Backtrack
        arr[row][col] = 1;
    }

    public static ArrayList<String> findSum(int[][] arr, int n) {
        ArrayList<String> ans = new ArrayList<>();
        solve(arr, n, 0, 0, "", ans);
        Collections.sort(ans);

        return ans;
    }
}
