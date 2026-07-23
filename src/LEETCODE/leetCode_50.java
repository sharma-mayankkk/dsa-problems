package LEETCODE;

//Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
public class leetCode_50 {
    public double solve(double x, long n) {
        if (n == 0) return 1;

        if (n < 0) return solve(1 / x, -n);

        if (n % 2 == 0) return solve(x * x, n / 2);

        return x * solve(x * x, (n - 1) / 2);
    }

    public double myPow(double x, int n) {
        return solve(x, (long) n);
    }
}
