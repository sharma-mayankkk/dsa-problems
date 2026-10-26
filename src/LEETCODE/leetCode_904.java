package LEETCODE;

import java.util.HashMap;
import java.util.Map;

//You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
//
//You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
//
//You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
//Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
//Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
//Given the integer array fruits, return the maximum number of fruits you can pick.
public class leetCode_904 {
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, maxLen = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;

        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            if (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) map.remove(fruits[l]);
                l++;
            }

            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }
        return maxLen;
    }
}
