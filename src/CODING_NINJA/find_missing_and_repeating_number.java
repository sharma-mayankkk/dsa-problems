package CODING_NINJA;

//Problem statement
//You are given an array of ‘N’ integers where each integer value is between ‘1’ and ‘N’. Each integer appears exactly once except for ‘P’, which appears exactly twice, and ‘Q’, which is missing.
//task is to find ‘P’ and ‘Q’ and return them respectively.
public class find_missing_and_repeating_number {
    public static int[] findMissingRepeatingNumbers(int[] a) {
        // Write your code here
        long n = a.length;

        long sn = (n * (n + 1)) / 2;
        long s2n = (n * (n + 1) * (2 * n + 1)) / 6;

        long s = 0, s2 = 0;

        for (int i : a) {
            s += i;
            s2 += (long) i * i;
        }

        long val1 = s - sn; //x-y
        long val2 = s2 - s2n;
        val2 /= val1; //x+y;

        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[]{(int) x, (int) y};
    }
}
