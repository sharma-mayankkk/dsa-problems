package STRIVERaTOz.BinarySearching.BSonAnswers;

//Kth Missing Positive Number
//Problem Statement: You are given a strictly increasing array ‘vec’ and a positive integer 'k'. Find the 'kth' positive integer missing from 'vec'.
public class array_06 {
    //bruteforce approach:
    public static int kthMissingNo(int[] arr, int k) {
        int num = 1, i = 0, n = arr.length;
        while (k > 0 && i < n) {
            if (arr[i] != num) {
                k--;
            } else {
                i++;
            }
            num++;
        }
        //for extra case where missing number is not in the array but beyond the array
        while (k-- > 0) {
            num++;
        }
        return num - 1;
    }

    //Binary search Approach:
    public static int KthMissingNo(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missingTillMid = arr[mid] - (mid + 1);
            if (missingTillMid < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + k;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println(KthMissingNo(arr, 5));
    }
}
