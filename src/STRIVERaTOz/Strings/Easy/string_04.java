package STRIVERaTOz.Strings.Easy;

import java.util.Arrays;

//Isomorphic String
//Problem Statement: Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
public class string_04 {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        int[] hash = new int[256];
        Arrays.fill(hash, 0);

        boolean[] isMapped = new boolean[256];
        Arrays.fill(isMapped, false);

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (hash[c1] == 0) {

                if (isMapped[c2]) {
                    return false;
                }

                hash[c1] = c2;
                isMapped[c2] = true;

            } else if (hash[c1] != c2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
