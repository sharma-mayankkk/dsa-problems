package LEETCODE;

//A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).
//
//Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.
public class leetCode_1392 {
    public static String longestPrefix(String s) {
        int n = s.length();
        int pre = 0, suf = 1;
        int[] lps = new int[n];

        while (suf < n) {
            if (s.charAt(pre) == s.charAt(suf)) {
                lps[suf] = pre + 1;
                pre++;
                suf++;
            } else {
                if (pre == 0) {
                    lps[suf] = 0;
                    suf++;
                } else {
                    pre = lps[pre - 1];
                }
            }
        }
        return s.substring(0, lps[n - 1]);
    }

    public static void main(String[] args) {
        System.out.println(longestPrefix("ababab"));
    }
}
