package LEETCODE;

import java.util.Arrays;

public class leetCode_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

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
}
