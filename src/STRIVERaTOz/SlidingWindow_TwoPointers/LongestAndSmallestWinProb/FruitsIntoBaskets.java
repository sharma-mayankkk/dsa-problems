package STRIVERaTOz.SlidingWindow_TwoPointers.LongestAndSmallestWinProb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//There is only one row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit produced by the ith tree.
//
//The goal is to gather as much fruit as possible, adhering to the owner's stringent rules:
//
//1) There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited.
//
//2) Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree. One of the baskets must hold the harvested fruits.
//
//3) Once reaching a tree with fruit that cannot fit into any basket, stop.
//
//Return the maximum number of fruits that can be picked.
public class FruitsIntoBaskets {
    //bruteForce solution:
    public static int fruitsInBasket(int[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < arr.length; j++) {
                set.add(arr[j]);
                if (set.size() <= 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else break;
            }
        }
        return maxLen;
    }

    public static int fruitsInBask(int[] arr) {
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            if (map.size() > 2) {
                while (map.size() > 2) {
                    map.put(arr[l], map.get(arr[l]) - 1);
                    if (map.get(arr[l]) == 0) map.remove(arr[l]);
                    l++;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static int fruitsInBaskets(int[] arr) {
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            if (map.size() > 2) {
                map.put(arr[l], map.get(arr[l]) - 1);
                if (map.get(arr[l]) == 0) map.remove(arr[l]);
                l++;
            }

            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(fruitsInBaskets(new int[]{1, 2, 3, 2, 2}));
    }
}
