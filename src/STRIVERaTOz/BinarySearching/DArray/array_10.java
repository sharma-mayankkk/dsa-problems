package STRIVERaTOz.BinarySearching.DArray;

//Minimum in Rotated sorted array:
public class array_10 {
    public static int minimumInRotatedSortedArray(int[] arr) {
        int low = 0, high = arr.length - 1, ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            //left half is sorted
            if (arr[mid] >= arr[low]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 1, 2, 3, 4};
        System.out.println(minimumInRotatedSortedArray(arr));
    }
}
