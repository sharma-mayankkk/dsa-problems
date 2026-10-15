package STRIVERaTOz.GreedyAlgorithm.SchedulingAndIntervalProblems;

import java.util.Arrays;

//Given a 2D array Intervals, where Intervals[i] = [start[i], end[i]] represents the start and end of the ith interval, the array represents non-overlapping intervals sorted in ascending order by start[i].
//
//Given another array newInterval, where newInterval = [start, end] represents the start and end of another interval, merge newInterval into Intervals such that Intervals remain non-overlapping and sorted in ascending order by start[i].
//
//Return Intervals after the insertion of newInterval.
public class InsertInterval {
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] ans = new int[n + 1][2];

        int i = 0, idx = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            ans[idx] = intervals[i];
            idx++;
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        ans[idx] = newInterval;
        idx++;

        while (i < n) {
            ans[idx++] = intervals[i++];
        }

        return Arrays.copyOf(ans, idx);
    }

    public static void main(String[] args) {

    }
}
