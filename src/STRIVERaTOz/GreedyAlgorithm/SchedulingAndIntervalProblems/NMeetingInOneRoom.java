package STRIVERaTOz.GreedyAlgorithm.SchedulingAndIntervalProblems;

import java.util.Arrays;

public class NMeetingInOneRoom {
    public static int nMeetingsInOneRoom(int[] start, int[] end, int n) {
        n = start.length;
        int[][] timer = new int[n][3];

        for (int i = 0; i < start.length; i++) {
            timer[i][0] = start[i];
            timer[i][1] = end[i];
            timer[i][2] = i + 1;
        }

        Arrays.sort(timer, (a, b) -> Integer.compare(a[1], b[1]));

        int maxMeetings = 0;
        int lastEnd = -1;

        for (int[] i : timer) {
            if (i[0] > lastEnd) {
                maxMeetings++;
                lastEnd = i[1];
            }
        }
        return maxMeetings;
    }

    public static void main(String[] args) {

        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        System.out.println(nMeetingsInOneRoom(start, end, start.length));
    }
}
