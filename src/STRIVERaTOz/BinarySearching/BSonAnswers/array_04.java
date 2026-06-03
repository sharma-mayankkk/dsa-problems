package STRIVERaTOz.BinarySearching.BSonAnswers;

//Find the Smallest Divisor Given a Threshold
//Problem Statement: You are given an array of integers 'arr' and an integer i.e. a threshold value 'limit'. Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it, the sum of the division's result is less than or equal to the given threshold value.
public class array_04 {
    public static int smallestDivisor(int[] arr, int tHold) {
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            max = Math.max(i, max);
        }

        for (int i = 1; i <= max; i++) {
            int sum = 0;
            for (int j : arr) {
                sum += Math.ceilDiv(j, i);
            }
            if (sum <= tHold) {
                return i;
            }
        }
        return -1;
    }

    //Binary search method:
    public static int findSum(int[] arr, int mid) {
        int sum = 0;
        for (int i : arr) {
            sum += (int) Math.ceil((double) i / mid);
        }
        return sum;
    }

    public static int smallestDivisor2(int[] arr, int tHold) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int i : arr) {
            high = Math.max(i, high);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (findSum(arr, mid) <= tHold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {44, 22, 33, 11, 1};
        System.out.println(smallestDivisor2(arr, 5));
    }
}
