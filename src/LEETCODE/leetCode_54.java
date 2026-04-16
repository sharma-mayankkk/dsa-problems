package LEETCODE;
import java.util.*;
//spiral matrix
public class leetCode_54 {


        public List<Integer> spiralOrder(int[][] matrix) {

            int m = matrix.length;
            int n = matrix[0].length;

            int left = 0, right = n - 1;
            int top = 0, bottom = m - 1;

            List<Integer> ans = new ArrayList<>();

            while (top <= bottom && left <= right) {

                // top row
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;

                // right column
                for (int i = top; i <= bottom; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;

                // bottom row
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        ans.add(matrix[bottom][i]);
                    }
                    bottom--;
                }

                // left column
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        ans.add(matrix[i][left]);
                    }
                    left++;
                }
            }

            return ans;
        }

}
