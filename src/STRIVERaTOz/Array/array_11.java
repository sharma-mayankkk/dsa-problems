package STRIVERaTOz.Array;

import java.util.HashMap;

//Doing the last question with other approaches and better solution:
public class array_11 {
    public static int findOnceAppearance(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }
        return -1;
    }

    //Optimal solution :
    public static int findSingleAppearance(int[] arr) {
        int xor = 0;
        for (int i : arr) {
            xor ^= i;
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 8, 8, 6};
        System.out.println(findSingleAppearance(arr));
    }
}
