package STRIVERaTOz.BinarySearching.DArray;

public class array_02 {
    public static int upperBound(int[] arr, int target ){
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) { //just removed the = sign form lowerbound code
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
