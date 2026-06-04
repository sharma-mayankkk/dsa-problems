package STRIVERaTOz.BinarySearching.BSonAnswers;

public class array_05 {
    public static int daysReq(int[] arr, int cap) {
        int days = 1, load = 0;
        for (int i : arr) {
            if (load + i > cap) {
                days += 1;
                load = i;
            } else {
                load += i;
            }
        }
        return days;
    }

    public static int shipWithinDays(int[] arr, int days) {
        int low = 0, high = 0;

        for (int i : arr) {
            low = Math.max(i, low);
            high += i;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (daysReq(arr, mid) > days) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(arr,5));
    }
}
