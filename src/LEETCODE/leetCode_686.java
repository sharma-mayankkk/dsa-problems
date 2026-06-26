package LEETCODE;

//Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.
//
//Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
public class leetCode_686 {
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

    public int KMP_MATCH(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();
        int[] lps = new int[n];
        findLPS(needle, lps);
        int first = 0, second = 0;

        while (first < m && second < n) {
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

        return second == n ? 1 : 0;
    }

    public int repeatedStringMatch(String a, String b) {
        if (a.equals(b)) return 1;
        int count = 0;
        StringBuilder temp = new StringBuilder();

        while (temp.length() < b.length()) {
            temp.append(a);
            count++;
        }

        if (KMP_MATCH(temp.toString(), b) == 1) {
            return count;
        }

        return KMP_MATCH(temp.append(a).toString(), b) == 1 ? count + 1 : -1;
    }
}
