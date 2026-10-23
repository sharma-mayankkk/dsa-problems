package STRIVERaTOz.SlidingWindow_TwoPointers.ConstantWindow;

//Given N cards arranged in a row, each card has an associated score denoted by the cardScore array.
//
//Choose exactly k cards. In each step, a card can be chosen either from the beginning or the end of the row.
//
//The score is the sum of the scores of the chosen cards.
//
//Return the maximum score that can be obtained.
public class MaximumPoints {
    public static int maximumPointsObtained(int[] arr, int k) {
        int rSum = 0, lSum = 0, maxSum = 0;
        for (int i = 0; i <= k - 1; i++) {
            lSum += arr[i];
        }
        maxSum = lSum;

        int idx = arr.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            lSum -= arr[i];
            rSum += arr[idx];
            maxSum = Math.max(maxSum, lSum + rSum);
            idx--;
        }
        return  maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maximumPointsObtained(new int[]{96,90,41,82,39,74,64,50,30},8));
    }
}
