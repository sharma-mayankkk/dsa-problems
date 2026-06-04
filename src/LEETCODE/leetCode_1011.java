package LEETCODE;
//A conveyor belt has packages that must be shipped from one port to another within days days.
//The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
//Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days.
public class leetCode_1011 {
    public static int daysReq(int[] arr, int cap) {
        int days = 1, load = 0;
        for (int i : arr) {
            if (i + load > cap) {
                days += 1;
                load = i;
            } else {
                load += i;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for (int i : weights) {
            low = Math.max(i, low);
            high += i;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (daysReq(weights, mid) > days) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
