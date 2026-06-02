package LEETCODE;
//You are given an integer array bloomDay, an integer m and an integer k.
//You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
//The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
//Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
public class leetCode_1482 {
    public static boolean possibleDays(int[] arr, int days, int m, int k) {
        int count = 0, noOfBouquet = 0;
        for (int i : arr) {
            if (i <= days) {
                count++;
            } else {
                noOfBouquet += count / k;
                count = 0;
            }
        }
        noOfBouquet += count / k;
        return noOfBouquet >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < ((long) m * k)) return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            low = Math.min(i, low);
        }

        for (int i : bloomDay) {
            high = Math.max(i, high);
        }
        int minDays = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possibleDays(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
