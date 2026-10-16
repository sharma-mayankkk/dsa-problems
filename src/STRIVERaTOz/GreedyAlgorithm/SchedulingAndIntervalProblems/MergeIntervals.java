package STRIVERaTOz.GreedyAlgorithm.SchedulingAndIntervalProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//10. Merge Intervals
//You are given an array intervals where intervals[i] = [startᵢ, endᵢ] represents the inclusive interval startᵢ ≤ x ≤ endᵢ.
//
//Your task is to merge every pair of intervals that overlap and return all the non-overlapping intervals that completely cover the same ranges as the original array.
//
//Two intervals overlap if they share at least one common point (i.e. start₂ ≤ end₁ and start₁ ≤ end₂).
//
//Return the merged intervals in any order.
public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> ans = new ArrayList<>();
        int[] newInterval = intervals[0];
        ans.add(newInterval);
        for (int[] ints : intervals) {
            if (ints[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], ints[1]);
            } else {
                newInterval = ints;
                ans.add(ints);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {9, 12}
        };

        System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
    }
}
