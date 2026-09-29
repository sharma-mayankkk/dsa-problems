package STRIVERaTOz.RecursionPatternWise.AllCombosHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static boolean isSafe(char[][] board, int row, int col, int n) {
        //horizontal check:
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //left diagonal:
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //right diagonal:
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueen(char[][] board, int row, int n, List<List<String>> ans) {
        if (row == n) {
            List<String> current = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }
            ans.add(current);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j, n)) {
                board[row][j] = 'Q';
                nQueen(board, row + 1, n, ans);
                board[row][j] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        nQueen(board, 0, n, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(12));
    }
}
