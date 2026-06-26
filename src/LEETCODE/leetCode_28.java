package LEETCODE;

//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
public class leetCode_28 {
    public static void findLPS(String needle, int[] lps) {
        int n = needle.length();
        int pre = 0, suf = 1;

        while (suf < n) {
            if (needle.charAt(pre) == needle.charAt(suf)) {
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
    }

    public static int strStr(String haystack, String needle) {
        int[] lps = new int[needle.length()];
        findLPS(needle, lps);

        int first = 0, second = 0;

        while (first < haystack.length() && second < needle.length()) {
            if (haystack.charAt(first) == needle.charAt(second)) {
                first++;
                second++;
            } else {
                if (second == 0) {
                    first++;
                } else {
                    second = lps[second - 1];
                }
            }
        }
        return second == needle.length() ? first - second : -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("leetcode","ing"));
    }
}
