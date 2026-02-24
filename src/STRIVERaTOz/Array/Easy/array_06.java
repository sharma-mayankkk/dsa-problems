package STRIVERaTOz.Array.Easy;

import java.util.*;
//union of two sorted arrays.
public class array_06 {
    //this is the brute force approach:
    public static int[] unionOfArrays(int[] arr, int[] arr2) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for (int i : arr2) {
            set.add(i);
        }

        int[] union = new int[set.size()];
        int j = 0;
        for (int i : set) {
            union[j] = i;
            j++;
        }

        return union;
    }

    //Optimal solution:

    public static ArrayList<Integer> unionOfArraysOptimal(int[] a, int[] b) {
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        while (i < a.length || j < b.length) {
            int val;
            if (j == b.length || (i < a.length && a[i] <= b[j]))
                val = a[i++];
            else
                val = b[j++];
            if (ans.isEmpty() || ans.get(ans.size() - 1) != val)
                ans.add(val);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 4, 6, 7, 8, 9};
        int[] result = unionOfArrays(arr, arr2);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
