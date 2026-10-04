package STRIVERaTOz.BitManipulation.Problems;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers where every element appears exactly twice except for one element which appears exactly once, find and return that unique element.
public class SingleNumber_1 {
    //BruteForce method:
    public static int singleNumber(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : arr) {
            if (map.get(i) > 1) return i;
        }

        return -1;
    }

    public static int singleNumber1(int[] arr){
        int xor = 0;
        for(int i: arr){
            xor^=i;
        }
        return xor;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber1(new int[]{1,1,2,2,3,4,4,5,5}));
    }
}
