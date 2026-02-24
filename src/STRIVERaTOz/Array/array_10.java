package STRIVERaTOz.Array;

import java.util.Arrays;

//Find the number that appears once, and the other numbers twice:
public class array_10 {
    //BruteForce Method:
    public static int findOnceAppear(int[] arr) {
        for (int i : arr) {
            int count = 0;
            for (int j : arr) {
                if (j == i) {
                    count++;
                }
            }
            if (count == 1) return i;
        }
        return -1;
    }

    //Better Solution: (hashing method)
    public static int singleAppearance(int[] arr) {
        int n = Arrays.stream(arr).max().getAsInt();
        int[] hashArray = new int[n + 1];

        for (int i : arr) {
            hashArray[i]++;
        }

        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] == 1) return i;
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 7, 7, 6, 11, 11};
        System.out.println(singleAppearance(arr));
    }
}
