package STRIVERaTOz.BitManipulation.Problems;

import java.util.Arrays;

public class SingleNumber_II {
    //extreme bruteforce will be solved by the hashing

    //bruteforce by using bit manipulation:
    public static int singleNumberII(int[] arr) {
        int ans = 0;
        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            int count = 0;
            for (int i : arr) {
                if ((i & (1 << bitIndex)) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) ans |= 1 << bitIndex;
        }
        return ans;
    }

    //using iteration:
    public static int singleNo(int[] arr) {
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i += 3) {
            if (arr[i] != arr[i - 1]) {
                return arr[i - 1];
            }
        }

        return arr[arr.length - 1];
    }

    //using bit manipulation:
    public static int singleNumero(int[] arr) {
        int ones = 0;
        int twos = 0;

        for (int i : arr) {
            ones = (ones ^ i) & (~twos);
            twos = (twos ^ i) & (~ones);
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(singleNumero(new int[]{1, 1, 3, 1, 5, 5, 5}));
    }
}
