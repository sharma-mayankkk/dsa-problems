package CODING_NINJA;

import java.util.HashMap;
import java.util.Map;

//Problem statement
//You are given a string 'str' and an integer ‘K’. Your task is to find the length of the largest substring with at most ‘K’ distinct characters.
//
//For example:
//You are given ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence, the answer is 7.
public class Longest_SubString_AtMost_K_distinct_char {
    public static int kDistinctChars(int k, String str) {
        // Write your code here
        int l = 0, r = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < str.length()) {
            map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0) + 1);

            if (map.size() > k) {
                map.put(str.charAt(l), map.get(str.charAt(l)) - 1);
                if (map.get(str.charAt(l)) == 0) map.remove(str.charAt(l));
                l++;
            }

            if (map.size() <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

}
