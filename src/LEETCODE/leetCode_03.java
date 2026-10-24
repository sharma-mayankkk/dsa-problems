package LEETCODE;

import java.util.Arrays;

public class leetCode_03 {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[255];
        Arrays.fill(hash, -1);

        int l = 0, r = 0, max = 0;
        int n = s.length();
        while (r < n) {
            if (hash[s.charAt(r)] != -1) {
                if (hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)] + 1;
                }
            }

            int len = r - l + 1;
            max = Math.max(max, len);
            hash[s.charAt(r)] = r;
            r++;
        }

        return max;
    }
}
