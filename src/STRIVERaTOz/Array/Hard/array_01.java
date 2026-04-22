package STRIVERaTOz.Array.Hard;
import java.util.*;
//Majority Elements(&gt;N/3 times) | Find the elements that appears more than N/3 times in the array
//Problem Statement: Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array. The output can be returned in any order.

//bruteForce approach:
public class array_01 {
    public static ArrayList<Integer> majorityElement(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (!list.contains(i)) {
                int count = 0;
                for (int j : arr) {
                    if (j == i) {
                        count++;
                    }
                }
                if (count > arr.length / 3) {
                    list.add(i);
                }
            }
            if (list.size() == 2) break;
        }
        return list;
    }

    //Better Solution:
    public static ArrayList<Integer> majorityElement2(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int mini = (arr.length / 3) + 1;

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) == mini) {
                list.add(i);
            }
            if (list.size() == 2) break;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3};
        System.out.println(majorityElement2(arr));
    }
}
