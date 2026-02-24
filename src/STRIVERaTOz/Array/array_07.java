package STRIVERaTOz.Array;

//Find missing number
public class array_07 {
    //BruteForce Approach:
    public static int missingNumber(int[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int j : arr) {
                if (j == i) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return -1;
    }

    //better solution with O(n) both time and space complexity.
    public static int returnMissing(int[] arr, int n) {
        int[] countNum = new int[n + 1];

        for (int i : arr) {
            countNum[i]++;
        }
        for (int i = 1; i <= n; i++) {
            if (countNum[i] == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        System.out.println(returnMissing(arr, 5));
    }
}
