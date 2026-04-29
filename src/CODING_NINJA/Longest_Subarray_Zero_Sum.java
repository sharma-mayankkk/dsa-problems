package CODING_NINJA;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

//Problem statement
//Ninja loves playing with numbers. So his friend gives him an array on his birthday. The array consists of positive and negative integers. Now Ninja is interested in finding the length of the longest subarray whose sum is zero.
public class Longest_Subarray_Zero_Sum {
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

        // Write your code here.
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, maxLen = 0;

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if (map.containsKey(sum)) {
                int lenght = i - map.get(sum);
                maxLen = Math.max(maxLen, lenght);
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
