package STRIVERaTOz.Array.Hard;

import java.util.HashMap;

//Count the number of subarrays with given xor K:
public class array_05 {
    //Better approach:
    public static int subarraysWithXORk(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //optimal solution:
    public static int subarraysWithXORk2(int[] arr, int k) {
        int xr = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : arr) {
            xr ^= i;
            int x = xr ^ k;
            if (map.containsKey(x)) {
                count += map.get(x);
            }
            map.put(xr, map.getOrDefault(xr, 0) + 1);

        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        System.out.println(subarraysWithXORk2(arr, 5));
    }
}
