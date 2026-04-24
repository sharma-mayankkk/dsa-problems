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

    //Optimal Solution:
    public static ArrayList<Integer> majorityElement3(int[] arr) {
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

        for (int i : arr) {
            if (cnt1 == 0 && i != ele2) {
                ele1 = i;
                cnt1++;
            } else if (cnt2 == 0 && i != ele1) {
                ele2 = i;
                cnt2++;
            } else if (ele1 == i) {
                cnt1++;
            } else if (ele2 == i) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for (int i : arr) {
            if (ele1 == i) cnt1++;
            if (ele2 == i) cnt2++;
        }
        int min = arr.length / 3 + 1;
        if (cnt1 >= min) ans.add(ele1);
        if (cnt2 >= min && ele2 != ele1) ans.add(ele2);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 3, 3, 5, 3, 6, 3, 7, 3, 8, 3, 9, 3, 10, 3, 11, 3, 12, 3, 13, 3, 14, 3, 15, 3, 16, 3};
        System.out.println(majorityElement3(arr));
    }
}
