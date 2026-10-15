package LEETCODE;
//You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//Two intervals are considered overlapping if they share at least one point.
//
//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//Return intervals after the insertion.
//
//Note that you don't need to modify intervals in-place. You can make a new array and return it.

import java.util.Arrays;

public class leetCode_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] ans = new int[n + 1][2];

        int i = 0, idx = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            ans[idx++] = intervals[i++];
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        ans[idx] = newInterval;
        idx++;

        while (i < n) {
            ans[idx++] = intervals[i++];
        }

        return Arrays.copyOf(ans, idx);
    }
}
