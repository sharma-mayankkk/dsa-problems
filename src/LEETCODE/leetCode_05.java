package LEETCODE;

//Given a string s, return the longest palindromic substring in s.
public class leetCode_05 {
    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            int oddLen = expand(s, i, i);
            int evenLen = expand(s, i, i + 1);

            int current = Math.max(oddLen, evenLen);

            if (max < current) {
                max = current;
                start = i - (current - 1) / 2;
            }
        }
        return s.substring(start, start + max);
    }
}
