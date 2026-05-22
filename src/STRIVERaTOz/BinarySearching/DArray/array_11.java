package STRIVERaTOz.BinarySearching.DArray;

//Find out how many times the array has been rotated
public class array_11 {
    public static int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1, ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //if array is not rotated:
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }
            //left half is sorted
            if (arr[mid] >= arr[low]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            } else {
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,1,2,3};
        System.out.println(findKRotation(arr));
    }
}
