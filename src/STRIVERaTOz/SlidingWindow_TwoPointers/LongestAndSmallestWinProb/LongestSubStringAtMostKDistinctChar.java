package STRIVERaTOz.SlidingWindow_TwoPointers.LongestAndSmallestWinProb;

import java.util.HashMap;
import java.util.Map;

//Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters.
//
//Example 1:
//Input : s = "aababbcaacc" , k = 2
//
//Output : 6
//
//Explanation : The longest substring with at most two distinct characters is "aababb".
//
//The length of the string 6.
public class LongestSubStringAtMostKDistinctChar {
    //BruteForce Solution:
    public static int longestSubString(String s, int k) {
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.clear();
            for (int j = i; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (map.size() <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else break;
            }
        }
        return maxLen;
    }

    //Optimal Solution:
    public static int longestSubString2(String s, int k) {
        int l = 0, r = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    //optimal solution:
    public static int longestSubString3(String s, int k) {
        int l = 0, r = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            if (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;
            }

            if (map.size() <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubString3("aababbcaacc", 2));
    }
}
