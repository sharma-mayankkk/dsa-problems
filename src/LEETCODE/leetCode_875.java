package LEETCODE;
//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//Return the minimum integer k such that she can eat all the bananas within h hours.
public class leetCode_875 {
    public static long totalHours(int[] arr, int hourly) {
        long totalHr = 0;
        for (int i : arr) {
            totalHr += (i + hourly - 1) / hourly;
        }
        return totalHr;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i : piles) {
            max = Math.max(i, max);
        }

        int low = 1, high = max;

        while (low <= high) {
            int mid = (low + high) / 2;
            long totalHrs = totalHours(piles, mid);
            if (totalHrs <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
