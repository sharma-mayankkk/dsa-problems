package CODING_NINJA;

import java.io.*;
import java.util.*;
import java.util.ArrayList;

//Given an array of integers ‘ARR’ and an integer ‘X’, you are supposed to find the number of subarrays of 'ARR' which have bitwise XOR of the elements equal to 'X'.
public class Count_Subarrays_Given_XOR {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        // Write your code here.
        int count = 0;
        int xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i : arr) {
            xor ^= i;
            int k = xor ^ x;
            if (map.containsKey(k)) {
                count += map.get(k);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
