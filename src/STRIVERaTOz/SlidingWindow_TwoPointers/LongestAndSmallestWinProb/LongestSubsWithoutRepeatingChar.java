package STRIVERaTOz.SlidingWindow_TwoPointers.LongestAndSmallestWinProb;

import java.util.Arrays;

public class LongestSubsWithoutRepeatingChar {
    //BruteForce approach
    public static int longestSubsWithoutRepeatingChar(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sub = new StringBuilder();
            int[] hash = new int[255];
            for (int j = i; j < s.length(); j++) {
                sub.append(s.charAt(j));
                if (hash[s.charAt(j)] == 1) break;
                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
                hash[s.charAt(j)] = 1;
            }
        }
        return maxLen;
    }

    //optimal solution:
    public static int longestSub(String s) {
        int[] hash = new int[255];
        Arrays.fill(hash, -1);
        int l = 0, r = 0, maxLen = 0;

        while (r < s.length()) {
            if (hash[s.charAt(r)] != -1) {
                if (hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)] + 1;
                }
            }
            int len = r - l + 1;
            maxLen = Math.max(len, maxLen);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsWithoutRepeatingChar("abcabcbb"));
        System.out.println(longestSub("abcabcbb"));
    }
}
