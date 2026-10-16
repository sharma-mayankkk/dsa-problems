package LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
public class leetCode_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> ans = new ArrayList<>();
        int[] newInterval = intervals[0];
        ans.add(newInterval);

        for (int[] inter : intervals) {
            if (inter[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], inter[1]);
            } else {
                newInterval = inter;
                ans.add(inter);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
