package STRIVERaTOz.SlidingWindow_TwoPointers.LongestAndSmallestWinProb;

//Given strings s1 and s2, return the minimum contiguous substring part of s1, so that s2 is a subsequence of the part.
//
//If there is no such window in s1 that covers all characters in s2, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
//
//Example 1:
//Input: s1 = "abcdebdde", s2 = "bde"
//
//Output: "bcde"
//
//Explanation:
//
//"bcde" is the answer because it occurs before "bdde" which has the same length.
//
//"deb" is not a smaller window because the elements of s2 in the window must occur in order.
public class MinWindowSubsequence {
    public static String minWinSubSeq(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) return "";
        String minWin = "";
        int j = 0, min = s.length() + 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
                if (j >= t.length()) {
                    int end = i + 1;
                    j--;

                    while (j >= 0) {
                        if (t.charAt(j) == s.charAt(i)) {
                            j--;
                        }
                        i--;
                    }
                    i++;
                    j++;
                    if (end - i < min) {
                        min = end - i;
                        minWin = s.substring(i, end);
                    }
                }
            }
        }
        return minWin;
    }

    public static void main(String[] args) {
        System.out.println(minWinSubSeq("abcdebdde","bde"));
    }
}
