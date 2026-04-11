package STRIVERaTOz.Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;

//Rearrange array elements by sign
public class array_04 {
    //Bruteforce approach: O(2N)
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

    //Optimal solution O(N)
    public static int[] rearrangeArr(int[] arr) {
        int[] ans = new int[arr.length];

        int posIndex = 0, negIndex = 1;
        for (int i : arr) {
            if (i < 0) {
                ans[negIndex] = i;
                negIndex += 2;
            } else {
                ans[posIndex] = i;
                posIndex += 2;
            }
        }
        return ans;
    }

    //Solution if the pos neg aren't equal.:
    public static int[] rearrangeArr2(int[] arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i : arr) {
            if (i > 0) pos.add(i);
            else neg.add(i);
        }

        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }

            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index] = pos.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }

            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(i);
                index++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, -4, -6, 2, -7, 13, 17, -1, 12, 11};
        System.out.println(Arrays.toString(rearrangeArr2(arr)));
    }
}
