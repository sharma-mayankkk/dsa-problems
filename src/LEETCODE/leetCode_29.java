package LEETCODE;

//Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
//
//The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
//
//Return the quotient after dividing dividend by divisor.
//
//Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
public class leetCode_29 {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        boolean sign = true; //positive
        if ((dividend <= 0 && divisor > 0) || (dividend >= 0 && divisor < 0)) sign = false;

        long nume = Math.abs((long) dividend), deno = Math.abs((long) divisor);
        long q = 0;

        for (int i = 31; i >= 0; i--) {
            long part = deno << i;

            if (part <= nume) {
                nume -= part;
                q += 1L << i;
            }
        }
        long result = sign ? q : -q;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
