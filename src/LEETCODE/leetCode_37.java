package LEETCODE;
//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//A sudoku solution must satisfy all the following rules:
//
//Each of the digits 1-9 must occur exactly once in each row.
//Each of the digits 1-9 must occur exactly once in each column.
//Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//The '.' character indicates empty cells.

public class leetCode_37 {
    public static boolean isSafe(char[][] board, int row, int col, char digit) {
        //horizontal check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) {
                return false;
            }
        }

        //vertical check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        //3X3 grid:
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i <= sr + 2; i++) {
            for (int j = sc; j <= sc + 2; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solver(char[][] board, int row, int col) {
        if (row == 9) return true;

        int nextRow = row;
        int nextCol = col + 1;

        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (board[row][col] != '.') {
            return solver(board, nextRow, nextCol);
        }

        //place correct digit at the place:
        for (char digit = '1'; digit <= '9'; digit++) {

            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit;
                if (solver(board, nextRow, nextCol)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        solver(board, 0, 0);
    }
}
