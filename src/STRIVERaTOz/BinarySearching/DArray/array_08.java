package STRIVERaTOz.BinarySearching.DArray;

//Search Element In a Rotated Sorted Array
public class array_08 {
    public static int searchInRotatedArray(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) return mid;

            if (arr[low] <= arr[mid]) {
                //left half is sorted:
                if (target <= arr[mid] && target >= arr[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //right half is sorted:
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 1, 2, 3, 4};
        System.out.println(searchInRotatedArray(arr, 3));
    }
}
