package CODING_NINJA;

import java.util.Arrays;

//Problem statement
//You are given the schedule of 'N' meetings with their start time 'Start[i]' and end time 'End[i]'.
//You have only 1 meeting room. So, you need to return the maximum number of meetings you can organize.
//Note:
//The start time of one chosen meeting can’t be equal to the end time of the other chosen meeting.
public class maximum_Meetings {
    public static int maximumMeetings(int[] start, int[] end) {
        // Write your code here.
        int n = start.length;
        int[][] timer = new int[n][3];

        for (int i = 0; i < start.length; i++) {
            timer[i][0] = start[i];
            timer[i][1] = end[i];
            timer[i][2] = i + 1;
        }

        Arrays.sort(timer, (a, b) -> Integer.compare(a[1], b[1]));

        int ans = 0;
        int lastEnd = -1;

        for (int[] time : timer) {
            if (time[0] > lastEnd) {
                ans++;
                lastEnd = time[1];
            }
        }

        return ans;
    }
}
