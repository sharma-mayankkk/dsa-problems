package STRIVERaTOz.BinarySearching.BSonAnswers;

import java.util.Arrays;

//Aggressive Cows
//Problem Statement: You are given an array 'arr' of size 'n' which denotes the position of stalls. You are also given an integer 'k' which denotes the number of aggressive cows.
//You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible. Find the maximum possible minimum distance.
public class array_07 {
    public static boolean isValid(int[] arr, int k, int minDistance) {
        int cowNumber = 1;
        int lastPosition = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[lastPosition] >= minDistance) {
                cowNumber++;
                lastPosition = i;

                if (cowNumber == k) { //Means all cow is placed:
                    return true;
                }
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 0, high = stalls[stalls.length - 1] - stalls[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(stalls, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] stalls = {4,2,1,3,6};
        System.out.println(aggressiveCows(stalls,2));
    }
}
