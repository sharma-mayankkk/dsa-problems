package STRIVERaTOz.BinarySearching.BSonAnswers;

public class array_01 {
    public int nthRoot(int n, int m) {
        // Loop from 1 to m
        for (int i = 1; i <= m; i++) {
            // Compute i^n
            long power = (long) Math.pow(i, n);

            // If equal to m, return i
            if (power == m) return i;

            // If exceeds m, break
            if (power > m) break;
        }
        // If not found, return -1
        return -1;
    }

    public static double multiply(double n, double num) {
        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans *= num;
        }

        return ans;
    }

    //using binary search:
    public static double NthRoot(double n, double m) {
        double low = 1;
        double high = m;
        double eps = 1e-6;

        while ((high - low) > eps) {
            double mid = (low + high) / 2.0;
            if (multiply(n, mid) > m) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(NthRoot(3, 27));
    }
}
