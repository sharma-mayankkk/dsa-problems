package STRIVERaTOz.GreedyAlgorithm.SchedulingAndIntervalProblems;

import java.util.Arrays;

//Given an 2D array Jobs of size Nx3, where Jobs[i][0] represents JobID , Jobs[i][1] represents Deadline , Jobs[i][2] represents Profit associated with that job. Each Job takes 1 unit of time to complete and only one job can be scheduled at a time.
//
//The profit associated with a job is earned only if it is completed by its deadline. Find the number of jobs and maximum profit.
public class JobSequencingProblem {
    public static int[] jobSequencing(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(b[2], a[2]));
        int maxDeadline = 0;
        for (int[] row : jobs) {
            maxDeadline = Math.max(maxDeadline, row[1]);
        }

        int[] arr = new int[maxDeadline + 1];
        Arrays.fill(arr, -1);

        int count = 0, profit = 0;

        for (int[] row : jobs) {
            for (int col = row[1]; col > 0; col--) {
                if (arr[col] == -1) {
                    arr[col] = row[0];
                    count++;
                    profit += row[2];
                    break;
                }
            }
        }

        return new int[]{count, profit};

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(jobSequencing(new int[][]{{1, 4, 20}, {2, 1, 10}, {3, 1, 40}, {4, 1, 30}})));
    }
}
