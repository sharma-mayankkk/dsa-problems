package LEETCODE;
//You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
//Return the length of the longest substring containing the same letter you can get after performing the above operations.
public class leetCode_424 {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        int[] hash = new int[26];

        while (r < s.length()) {
            int charIndex = s.charAt(r) - 'A';
            hash[charIndex]++;
            maxFreq = Math.max(maxFreq, hash[charIndex]);

            if ((r - l + 1) - maxFreq > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
