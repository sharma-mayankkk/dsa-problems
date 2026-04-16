package STRIVERaTOz.Array.Medium;

//Print the matrix in spiral manner
public class array_09 {
    public static int[] spiralMatrix(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;

        int[] ans = new int[m * n];
        int index = 0;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                ans[index++] = arr[top][i];
            }

            top++;
            for (int i = top; i <= bottom; i++) {
                ans[index++] = arr[i][right];
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[index++] = arr[bottom][i];
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[index++] = arr[i][left];
                }
                left++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] result = spiralMatrix(arr);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
