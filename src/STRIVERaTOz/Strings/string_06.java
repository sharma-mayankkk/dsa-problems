package STRIVERaTOz.Strings;

import java.util.Arrays;

//Valid Anagram
public class string_06 {
    //approach one:
    public static boolean checkAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }

    //approach two:
    public static boolean checkAnagram2(String s, String t) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }

        for (int i : count) {
            if (i != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkAnagram2("chutiyaa", "tiyachu"));
    }
}
