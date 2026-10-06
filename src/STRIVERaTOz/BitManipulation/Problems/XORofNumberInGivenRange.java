package STRIVERaTOz.BitManipulation.Problems;

public class XORofNumberInGivenRange {
    //bruteforce:
    public static int xorOfaRange(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans ^= i;
        }
        return ans;
    }

    //optimized approach:
    public static int xorInaRange(int n) {
        if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n + 1;
        else if (n % 4 == 3) return 0;

        return n;
    }

    //TWISTED QUESTION:
    public static int xorInRange(int L, int R) {
        return xorInaRange(L - 1) ^ xorInaRange(R);
    }

    public static void main(String[] args) {
        System.out.println(xorInRange(3, 5));
    }
}
