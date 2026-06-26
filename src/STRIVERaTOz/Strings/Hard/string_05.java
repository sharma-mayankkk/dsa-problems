package STRIVERaTOz.Strings.Hard;

//KMP Algorithm or LPS Array:
//Problem Statement: Given two strings, one is a text string and the other is a pattern string. Find and print the indices of all the occurrences of the pattern string within the text string. Use 0-based indexing for the indices, and ensure that the indices are in ascending order. If the pattern does not occur in the text, return an empty list.
//Implement this solution using the Knuth-Morris-Pratt (KMP) algorithm for efficient pattern matching.
public class string_05 {
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

    public static int firstAppearance(String haystack, String needle) {
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
        if (second == needle.length()) {
            return first - second;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstAppearance("leetcode","cod"));
    }
}
