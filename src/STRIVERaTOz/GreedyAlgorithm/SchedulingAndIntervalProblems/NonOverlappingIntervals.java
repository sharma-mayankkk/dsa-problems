package STRIVERaTOz.GreedyAlgorithm.SchedulingAndIntervalProblems;
//Given an array of N intervals in the form of (start[i], end[i]), where start[i] is the starting point of the interval and end[i] is the ending point of the interval, return the minimum number of intervals that need to be removed to make the remaining intervals non-overlapping.

import java.util.Arrays;

//Intervals which only touch at a point are also considered as non-overlapping. For example, [1, 3] and [3, 4] are non-overlapping.
public class NonOverlappingIntervals {
    public static int nonOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1, lastEndTime = intervals[0][1];

        for (int[] interval : intervals) {
            if (interval[0] >= lastEndTime) {
                count++;
                lastEndTime = interval[1];
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        System.out.println(nonOverlappingIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
