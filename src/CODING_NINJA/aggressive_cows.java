package CODING_NINJA;

import java.util.Arrays;
//Problem statement
//You are given an array 'arr' consisting of 'n' integers which denote the position of a stall.
//You are also given an integer 'k' which denotes the number of aggressive cows.
//You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
//Print the maximum possible minimum distance.
public class aggressive_cows {
    public static boolean isValid(int[] stalls, int k, int minDistance) {
        int cowCount = 1;
        int lastPos = 0;

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[lastPos] >= minDistance) {
                cowCount++;
                lastPos = i;

                if (k == cowCount) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int low = 1, high = stalls[stalls.length - 1] - stalls[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(stalls, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
