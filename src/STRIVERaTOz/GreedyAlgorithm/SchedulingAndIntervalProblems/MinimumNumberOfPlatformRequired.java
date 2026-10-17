package STRIVERaTOz.GreedyAlgorithm.SchedulingAndIntervalProblems;

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

    public static void main(String[] args) {

    }
}
