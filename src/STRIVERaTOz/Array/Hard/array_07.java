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

    //optimal solution-1:(sum method) : TC-O(n) and SC-O(1);
    public static int[] findMissingNumber3(int[] arr) {
        long n = arr.length;
        //sum of all elements of the array - sum of 1 to n integers: S-Sn = x-y
        //sum of square of all elements of the array - sum of square of 1 to n integers: S2-S2n = x^2-y^2

        long s = 0, s2 = 0;  //sum/square sum of elements of array

        long sn = (n * (n + 1)) / 2;
        long s2n = (n * (n + 1) * (2 * n + 1)) / 6;

        for (int i : arr) {
            s += i;
            s2 += (long) i * i;
        }

        long val1 = s - sn; //x-y;
        long val2 = s2 - s2n;
        val2 /= val1; //x+y;

        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[]{(int) x, (int) y}; //x = repeating and y= missing;

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5};
        System.out.println(Arrays.toString(findMissingNumber3(arr)));
    }
}
