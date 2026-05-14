package STRIVERaTOz.BinarySearching.DArray;

public class array_04 {
    public static void findFloorCeil(int[] arr, int x) {
        int floor = -1, ceil = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }

            if (arr[mid] < x) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }
    }
}
