package STRIVERaTOz.RecursionPatternWise.AllCombosHard;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public static void findAns(int[][] maze, int row, int col, String path, List<String> ans) {
        int m = maze.length;
        int n = maze[0].length;
        if (row < 0 || col < 0 || row >= m || col >= n || maze[row][col] == 0 || maze[row][col] == -1) return;

        if (row == m - 1 && col == n - 1) {
            ans.add(path);
            return;
        }

        maze[row][col] = -1;
        //down
        findAns(maze, row + 1, col, path + "D", ans);
        //up
        findAns(maze, row - 1, col, path + "U", ans);
        //right
        findAns(maze, row, col + 1, path + "R", ans);
        //left
        findAns(maze, row, col - 1, path + "L", ans);

        maze[row][col] = 1;
    }

    public static List<String> ratInMaze(int[][] maze) {
        List<String> ans = new ArrayList<>();
        String s = "";

        findAns(maze, 0, 0, s, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        System.out.println(ratInMaze(maze));
    }
}
