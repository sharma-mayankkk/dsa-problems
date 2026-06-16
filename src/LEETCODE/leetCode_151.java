package LEETCODE;

//Given an input string s, reverse the order of the words.
//
//A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
//
//Return a string of the words in reverse order concatenated by a single space.
//
//Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
public class leetCode_151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            sb.append(s, j + 1, i + 1);

            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
            }

            if (j >= 0) {
                sb.append(' ');
            }

            i = j;
        }
        return sb.toString();
    }
}
