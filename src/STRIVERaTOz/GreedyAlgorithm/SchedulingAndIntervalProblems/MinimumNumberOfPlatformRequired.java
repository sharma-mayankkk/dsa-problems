package STRIVERaTOz.GreedyAlgorithm.SchedulingAndIntervalProblems;

import java.util.Arrays;

//Given the arrival and departure times of all trains reaching a particular railway station, determine the minimum number of platforms required so that no train is kept waiting. Consider all trains arrive and depart on the same day.
//
//In any particular instance, the same platform cannot be used for both the departure of one train and the arrival of another train, necessitating the use of different platforms in such cases.
//
//Note: Time intervals are in the minutes , Leading zeros for minutes less than 1000 are optional (e.g., 0900 is the same as 900).
public class MinimumNumberOfPlatformRequired {
    public static int minimumPlatformReq(int[] arr, int[] dep) {
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = 0; j < dep.length; j++) {
                if (i != j) {
                    if (arr[i] >= arr[j] && arr[i] <= dep[j]) {
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static int minNoOfPlatformReq(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 0, maxCount = 0;
        int i = 0, j = 0;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                count++;
                maxCount = Math.max(maxCount, count);
                i++;
            } else {
                count--;
                j++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(minimumPlatformReq(arr, dep));
    }
}
