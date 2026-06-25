package STRIVERaTOz.Strings.Hard;
//Longest Happy Prefix

//Problem Statement: Given a string s, return the longest happy prefix of s. A happy prefix is a string that is both a proper prefix and a proper suffix.
//If no such prefix exists, return an empty string .
//
//Note: A proper prefix/proper suffix of a string is any prefix/suffix that is not equal to the entire string.
public class string_07 {
    public static String longestHappyPrefix(String s) {
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
        System.out.println(longestHappyPrefix("ababab"));
    }
}
