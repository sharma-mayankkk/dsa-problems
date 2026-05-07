package STRIVERaTOz.Array.Hard;

import java.util.ArrayList;

//Count Reverse Pairs
//Problem Statement: Given an array of numbers, you need to return the count of reverse pairs. Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].
public class array_09 {
    public static void merge(ArrayList<Integer> arr, int left, int mid, int right){
        ArrayList<Integer> temp = new ArrayList<>();
        int i = left;
        int j = mid + 1;

        // Merge both halves
        while (i <= mid && j <= right) {
            if (arr.get(i) <= arr.get(j)) {
                temp.add(arr.get(i));
                i++;
            } else {
                temp.add(arr.get(j));
                j++;
            }
        }

        // Left half remaining
        while (i <= mid) {
            temp.add(arr.get(i));
            i++;
        }

        // Right half remaining
        while (j <= right) {
            temp.add(arr.get(j));
            j++;
        }
        // Copy back to original array
        for (int k = 0; k < temp.size(); k++) {
            arr.set(left + k, temp.get(k));
        }
    }
    //function to count pairs:

    public static int countPairs(ArrayList<Integer> arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr.get(i) > 2 * (arr.get(right))) right++;
            count += (right - (mid + 1));
        }
        return count;
    }

    public static int mergeSort(ArrayList<Integer> arr, int low, int high) {
        int count = 0;
        if (low == high) return count;
        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);

        return count;
    }

    //optimal solution for it :
    public static int solution(ArrayList<Integer> arr) {
        return mergeSort(arr, 0, arr.size() - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(3);
        arr.add(1);

        int ans = solution(arr);

        System.out.println("Reverse Pairs Count = " + ans);
    }
}
