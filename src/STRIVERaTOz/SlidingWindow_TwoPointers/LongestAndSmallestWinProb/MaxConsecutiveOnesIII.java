package STRIVERaTOz.SlidingWindow_TwoPointers.LongestAndSmallestWinProb;

//Given a binary array nums and an integer k, flip at most k 0's.
//Return the maximum number of consecutive 1's after performing the flipping operation.
public class MaxConsecutiveOnesIII {
    //BruteForce Solution:
    public static int maxConsecutiveOnes(int[] arr, int k) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int zeroes = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 0) zeroes++;
                if (zeroes <= k) {
                    int len = j - i + 1;
                    maxLen = Math.max(len, maxLen);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    //Sliding window (two pointers) Approach:
    public static int maxConsOnes(int[] arr, int k) {
        int l = 0, r = 0, maxLen = 0, zeroes = 0;

        while (r < arr.length) {
            if (arr[r] == 0) {
                zeroes++;
                while (zeroes > k) {
                    if (arr[l] == 0) {
                        zeroes--;
                    }
                    l++;
                }
            }

            if (zeroes <= k) {
                int len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }
            r++;
        }
        return maxLen;
    }

    //optimal solution:
    public static int maxConsOnesAgain(int[] arr, int k) {
        int l = 0, r = 0, maxLen = 0, zeroes = 0;

        while (r < arr.length) {
            if (arr[r] == 0) zeroes++;

            if (zeroes > k) {
                if (arr[l] == 0) zeroes--;
                l++;
            }

            if (zeroes <= k) {
                int len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxConsOnesAgain(new int[]{0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
