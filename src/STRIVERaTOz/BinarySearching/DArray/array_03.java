package STRIVERaTOz.BinarySearching.DArray;
//Search Insert Position
//Problem Statement: You are given a sorted array arr of distinct values and a target value x. You need to search for the index of the target value in the array.
public class array_03 {
    public static int insertPosition(int[] arr, int target){
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

    }
}
