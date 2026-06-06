package CODING_NINJA;

import java.util.ArrayList;
import java.util.Collections;
//Problem statement
//Given an array/list of length ‘n’, where the array/list represents the boards and each element of the given array/list represents the length of each board. Some ‘k’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint.
//You are supposed to return the area of the minimum time to get this job done of painting all the ‘n’ boards under a constraint that any painter will only paint the continuous sections of boards.
public class painters_partitions {
    static boolean isValid(ArrayList<Integer> boards, int k, int mid) {
        int painters = 1;
        int boardsPainted = 0;

        for (int i : boards) {
            if (boardsPainted + i <= mid) {
                boardsPainted += i;
            } else {
                painters++;
                if (painters > k || i > mid) {
                    return false;
                }
                boardsPainted = i;
            }
        }
        return true;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        //    Write your code here.
        if (boards.size() < k || boards.isEmpty()) return -1;

        int low = Collections.max(boards), high = 0;
        for (int i : boards) {
            high += i;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(boards, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}