package LEETCODE;

import java.util.Arrays;

//Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
//
//Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
public class leetCode_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1, lastEnd = intervals[0][1];

        for (int[] inter : intervals) {
            if (inter[0] >= lastEnd) {
                count++;
                lastEnd = inter[1];
            }
        }
        return n - count;
    }
}
