package STRIVERaTOz.BinarySearching.BSonAnswers;


//Problem Statement: You are given 'N’ roses, and you are also given an array 'arr' where 'arr[i]' denotes that the 'ith' rose will bloom on the 'arr[i]th' day. You can only pick already bloomed roses that are adjacent to make a bouquet. You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet. Find the minimum number of days required to make at least ‘m' bouquets each containing 'k' roses. Return -1 if it is not possible.
public class array_03 {
    //bruteforce approach:
    public static boolean possibleDays(int[] arr, int days, int bouquet, int flower) {
        int count = 0, noOfBouquet = 0;

        for (int i : arr) {
            if (i <= days) {
                count++;
            } else {
                noOfBouquet += count / flower;
                count = 0;
            }
        }
        noOfBouquet += count / flower;
        return noOfBouquet >= bouquet;
    }

    public static int minDays(int[] arr, int bouquet, int flowers) {
        if (arr.length < ((long) bouquet * flowers)) return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            min = Math.min(i, min);
        }

        for (int i : arr) {
            max = Math.max(i, max);
        }

        for (int i = min; i <= max; i++) {
            if (possibleDays(arr, i, bouquet, flowers)) {
                return i;
            }
        }
        return -1;
    }

    //binary search method:
    public static int minDays2(int[] arr, int bouquet, int flowers){
        if (arr.length < ((long) bouquet * flowers)) return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i : arr) {
            low = Math.min(i, low);
        }

        for (int i : arr) {
            high = Math.max(i, high);
        }
        int minDays = 0;
        while(low <= high){
            int mid = (low+high)/2;
            if(possibleDays(arr,mid,bouquet,flowers)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        System.out.println(minDays2(bloomDay,2,3));
    }
}
