package STRIVERaTOz.SlidingWindow_TwoPointers.ConstantWindow;

public class Basics {
    //longest subArray with sum <= K
    public static int longestSub(int[] arr, int k) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum <= k) {
                    max = Math.max(max, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return max;
    }

    //better solution:
    public static int longestSubArr(int[] arr, int k) {
        int l = 0, r = 0, maxLen = 0, sum = 0;

        while (r < arr.length) {
            sum += arr[r];
            while (sum > k) {
                sum -= arr[l];
                l++;
            }
            if (sum <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    //optimal solution
    public static int longestSubArrSum(int[] arr, int k) {
        int l = 0, r = 0, maxLen = 0, sum = 0;

        while (r < arr.length) {
            sum += arr[r];
            if (sum > k) {
                sum -= arr[l];
                l++;
            }
            if (sum <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubArr(new int[]{1, 2, 3, 4, 5}, 12));
    }
}
