package STRIVERaTOz.Array.Hard;

import java.util.HashMap;

//Length of the longest subarray with zero Sum
public class array_04 {
    public static int largestSubarray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //store first occurrence of 0 at -1 index:
        int sum = 0, max = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                int length = i - map.get(sum);
                max = Math.max(max, length);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(largestSubarray(arr));
    }
}
