package STRIVERaTOz.Sorting;

import java.util.ArrayList;

public class merge_sort {
    public static void merge(ArrayList<Integer> arr, int left, int mid, int right) {
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

    public static void mergeSort(ArrayList<Integer> arr, int low, int high) {
        if (low == high) return;
        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(8);
        arr.add(1);
        arr.add(3);

        mergeSort(arr, 0, arr.size() - 1);

        System.out.println(arr);
    }
}
