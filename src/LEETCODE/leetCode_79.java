package LEETCODE;
//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
public class leetCode_79 {
    static final int[] di = {-1, 1, 0, 0};
    static final int[] dj = {0, 0, -1, 1};

    public boolean find(char[][] board, int i, int j, int index, int m, int n, String word) {
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '$') {
            return false;
        }

        if (board[i][j] != word.charAt(index)) return false;

        board[i][j] = '$';

        for (int k = 0; k < 4; k++) {
            int newI = i + di[k];
            int newJ = j + dj[k];

            if (find(board, newI, newJ, index + 1, m, n, word)) return true;
        }

        board[i][j] = word.charAt(index);
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && find(board, i, j, 0, m, n, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
