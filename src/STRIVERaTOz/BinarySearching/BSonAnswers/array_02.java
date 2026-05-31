package STRIVERaTOz.BinarySearching.BSonAnswers;
import java.util.Arrays;

//Problem Statement: A monkey Koko is given ‘n’ piles of bananas, whereas the 'ith' pile has ‘a[i]’ bananas. An integer ‘h’ is also given, which denotes the time (in hours) for all the bananas to be eaten.
//Each hour, the monkey chooses a non-empty pile of bananas and eats ‘k’ bananas. If the pile contains less than ‘k’ bananas, then the monkey consumes all the bananas and won’t eat any more bananas in that hour.
//Find the minimum number of bananas ‘k’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.
public class array_02 {
    public static int totalHour(int[] arr, int hourly) {
        int totalHr = 0;
        for (int i : arr) {
            totalHr += (int) Math.ceil((double) i / hourly);
        }
        return totalHr;
    }

    public static int minEatingSpeed(int[] arr, int h) {
        int low = 1, high = Arrays.stream(arr).max().getAsInt();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalHrs = totalHour(arr, mid);
            if (totalHrs <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] piles = {2,7,13,11,3};
        System.out.println(minEatingSpeed(piles,8));
    }
}
