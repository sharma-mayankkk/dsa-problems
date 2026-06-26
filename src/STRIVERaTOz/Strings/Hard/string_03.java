package STRIVERaTOz.Strings.Hard;

//Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for 'b' to be a substring of "a" after repeating it, return -1.
//Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
public class string_03 {
    public static int repeatedStringMatch(String a, String b) {
        StringBuilder repeated = new StringBuilder();
        int count = 0;
        while (repeated.length() < b.length()) {
            repeated.append(a);
            count++;
        }

        if (repeated.indexOf(b) != -1) {
            return count;
        }

        repeated.append(a);
        if (repeated.indexOf(b) != -1) {
            return count + 1;
        }

        return -1;
    }

    //optimized Approach with KMP algorithm:
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

    public int strStr(String haystack, String needle) {
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
        System.out.println(repeatedStringMatch("abcd", "xyz "));
    }
}
