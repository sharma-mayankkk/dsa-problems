package STRIVERaTOz.BitManipulation.Problems;

public class DivideTwoNumsWithoutMulAndDiv {
    //BruteForce:
    public static int divide(int divisor, int dividend) {
        int count = 0, temp = 0;

        while (temp <= dividend) {
            temp += divisor;
            count++;
        }
        return count - 1;
    }

    //better solution:
    public static int divideTwoNums(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        boolean sign = true; //positive
        if ((dividend <= 0 && divisor > 0) || (dividend >= 0 && divisor < 0)) sign = false;

        long dividendAbs = Math.abs((long) dividend), divisorAbs = Math.abs((long) divisor);
        long quotient = 0;

        for (int shift = 31; shift >= 0; shift--) {
            long chunk = divisorAbs << shift;

            if (chunk <= dividendAbs) {
                dividendAbs -= chunk;
                quotient += 1L << shift;
            }
        }

        long result = sign ? quotient : (-1) * quotient;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;

    }

    public static void main(String[] args) {
        System.out.println(divideTwoNums(22, 3));
    }
}
