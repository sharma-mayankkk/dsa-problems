package CODING_NINJA;
//Problem statement
//You are given a 'Nx3' 2-D array 'Jobs' describing 'N' jobs where 'Jobs[i][0]' denotes the id of 'i-th' job, 'Jobs[i][1]' denotes the deadline of 'i-th' job, and 'Jobs[i][2]' denotes the profit associated with 'i-th job'.
//You will make a particular profit if you complete the job within the deadline associated with it. Each job takes 1 unit of time to be completed, and you can schedule only one job at a particular time.

import java.util.Arrays;

//Return the number of jobs to be done to get maximum profit.
//Note :
//If a particular job has a deadline 'x', it means that it needs to be completed at any time before 'x'.
//
//Assume that the start time is 0.
public class job_sequencing {
    public static int[] jobScheduling(int[][] jobs) {
        // Write your code here
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
}
