package STRIVERaTOz.Array.Hard;

import java.util.Arrays;

//Find the repeating and missing numbers
public class array_07 {

    //bruteForce approach : 0(n^2) & O(1):
    public static int[] findMissingNumber(int[] arr, int n) {
        int repeating = -1, missing = -1;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j : arr) {
                if (i == j) {
                    count++;
                }
            }
            if (count == 0) missing = i;
            else if (count == 2) {
                repeating = i;
            }
            if (missing != -1 && repeating != -1) break;
        }
        return new int[]{missing, repeating};
    }

    //better solution:TC = O(2n) and SC: O(n)
    public static int[] findMissingNumber2(int[] arr) {
        int n = arr.length;
        int[] hashArr = new int[n + 1];

        for (int i : arr) {
            hashArr[i]++;
        }

        int repeating = -1, missing = -1;
        for (int i = 1; i < hashArr.length; i++) {
            if (hashArr[i] == 2) repeating = i;
            else if (hashArr[i] == 0) missing = i;

            if (missing != -1 && repeating != -1) break;
        }
        return new int[]{missing, repeating};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5};
        System.out.println(Arrays.toString(findMissingNumber2(arr)));
    }
}
