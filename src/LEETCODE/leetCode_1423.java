package LEETCODE;

//There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
//
//In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
//
//Your score is the sum of the points of the cards you have taken.
//
//Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
public class leetCode_1423 {
    public int maxScore(int[] cardPoints, int k) {
        int rSum = 0, lSum = 0, maxSum = 0;
        for (int i = 0; i <= k - 1; i++) {
            lSum += cardPoints[i];
        }

        maxSum = lSum;

        int idx = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            lSum -= cardPoints[i];
            rSum += cardPoints[idx];
            maxSum = Math.max(maxSum, rSum + lSum);
            idx--;
        }
        return maxSum;
    }
}
