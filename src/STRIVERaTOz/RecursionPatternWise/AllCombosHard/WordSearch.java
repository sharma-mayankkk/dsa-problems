package STRIVERaTOz.RecursionPatternWise.AllCombosHard;

public class WordSearch {
    static final int[] di = {-1, 1, 0, 0};
    static final int[] dj = {0, 0, -1, 1};

    public static boolean find(char[][] board, int i, int j, int index, String word, int m, int n) {

        if (index == word.length()) return true;

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '$') {
            return false;
        }

        if (board[i][j] != word.charAt(index)) return false;

        board[i][j] = '$';

        for (int k = 0; k < 4; k++) {
            int nextI = i + di[k];
            int nextJ = j + dj[k];

            if (find(board, nextI, nextJ, index + 1, word,m,n)) return true;
        }
        board[i][j] = word.charAt(index);

        return false;
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && find(board, i, j, 0, word, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'D', 'A', 'C', 'D'},
                {'X', 'C', 'X', 'X'},
                {'X', 'X', 'X', 'X'}
        };

        String word = "ACD";
        System.out.println(exist(board,word));
    }
}
