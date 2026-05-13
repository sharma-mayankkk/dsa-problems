package STRIVERaTOz.BinarySearching.DArray;

public class array_01 {
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 8, 8, 10};
        System.out.println(lowerBound(arr, 7));
    }
}
