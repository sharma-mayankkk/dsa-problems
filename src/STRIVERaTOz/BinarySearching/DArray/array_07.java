package STRIVERaTOz.BinarySearching.DArray;

//count number of occurrence:
public class array_07 {
    public static int firstOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    public static int lastOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    public static int countOccurrence(int[] arr, int x) {
        return lastOccurrence(arr, x) - firstOccurrence(arr, x) + 1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(countOccurrence(arr, 7));
    }
}
