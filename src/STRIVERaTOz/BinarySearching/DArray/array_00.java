package STRIVERaTOz.BinarySearching.DArray;

public class array_00 {
    //iterative approach:
    public static int binarySearch(int[] arr, int target) {
        int si = 0, ei = arr.length - 1;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return -1;
    }

    //recursive approach;
    public static int binarySearch2(int[] arr, int si, int ei, int target) {
        if (si > ei) return -1;
        int mid = (si + ei) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch2(arr, si, mid - 1, target);
        } else {
            return binarySearch2(arr, mid + 1, ei, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 13, 17, 19, 42};
        System.out.println(binarySearch2(arr, 0, arr.length - 1, 20));
    }
}
