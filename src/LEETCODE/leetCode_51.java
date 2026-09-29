package LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//
//Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
public class leetCode_51 {
    public static boolean isSafe(char[][] board, int row, int col, int n) {
        //horizontal check:
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        //vertical check
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

    public static void nQueens(char[][] board, int row, int n, List<List<String>> ans) {
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
                nQueens(board, row + 1, n, ans);
                board[row][j] = '.';
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> ans = new ArrayList<>();
        nQueens(board, 0, n, ans);
        return ans;
    }
}
