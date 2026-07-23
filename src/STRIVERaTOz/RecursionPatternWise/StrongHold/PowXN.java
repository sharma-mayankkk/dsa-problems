package STRIVERaTOz.RecursionPatternWise.StrongHold;

//Implement Pow(x,n) | X raised to the power N
//Problem Statement: Implement the power function pow(x, n) , which calculates the x raised to n i.e. xn.
public class PowXN {
    public static double solve(double x, long n) {
        if (n == 0) return 1;

        if (n < 0) return solve(1 / x, -n);

        if (n % 2 == 0) return solve(x * x, n / 2);

        return x * solve(x * x, (n - 1) / 2);
    }

    public static double power(double x, int n) {
        return solve(x, (long) n);
    }

    public static void main(String[] args) {
        System.out.println(power(5, -2));
    }
}
