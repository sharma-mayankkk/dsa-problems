package STRIVERaTOz.SlidingWindow_TwoPointers.LongestAndSmallestWinProb;
//Given two strings s and t. Find the smallest window substring of s that includes all characters in t (including duplicates) , in the window. Return the empty string "" if no such substring exists.

import java.util.HashMap;

//Example 1:
//Input : s = "ADOBECODEBANC" , t = "ABC"
//
//Output : "BANC"
//
//Explanation : The minimum window substring of string s that contains the string t is "BANC".
//
//Example 2:
//Input : s = "a" , t = "a"
//
//Output : "a"
//
//Explanation : The complete string is the minimum window
public class MinWindowSubstring {
    public static String minWindowSub(String s, String t) {
        int n = s.length();

        if (t.length() > n) return "";


        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int reqCount = t.length();
        int i = 0, j = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        while (j < n) {
            if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) > 0) {
                reqCount--;
            }

            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) - 1);
            while (reqCount == 0) {
                int currentWin = j - i + 1;
                if (currentWin < minLength) {
                    minLength = currentWin;
                    startIndex = i;
                }
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.get(s.charAt(i)) > 0) reqCount++;
                i++;
            }
            j++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }

    public static void main(String[] args) {
        System.out.println(minWindowSub("ADOBECODEBANC", "ABC"));
    }
}
