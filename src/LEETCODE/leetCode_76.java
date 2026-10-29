package LEETCODE;

import java.util.HashMap;
import java.util.Map;

//Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
//
//The testcases will be generated such that the answer is unique.
//
//
//
//Example 1:
//
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
//Example 2:
//
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
//Example 3:
//
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
public class leetCode_76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int reqCount = t.length();
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        while (r < s.length()) {
            if (map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) > 0) {
                reqCount--;
            }

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) - 1);

            while (reqCount == 0) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }

                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
                if (map.get(s.charAt(l)) > 0) reqCount++;
                l++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
