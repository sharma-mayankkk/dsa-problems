package STRIVERaTOz.Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;

//Rearrange array elements by sign
public class array_04 {
    //Bruteforce approach:
    public static int[] rearrangeArray(int[] arr) {
        int n = arr.length;

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i : arr) {
            if (i > 0) pos.add(i);
            else neg.add(i);
        }

        int[] result = new int[n];
        int i = 0, j = 0, k = 0;

        while (i < pos.size() && j < neg.size()) {
            result[k++] = pos.get(i++);
            result[k++] = neg.get(j++);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, -4, -6, 2, -7, -1};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }
}
