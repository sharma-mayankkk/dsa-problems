package CODING_NINJA;

//Problem statement
//You are given two strings ‘S’ and ‘T’. Your task is to find the minimum (Contiguous) substring ‘W’ of ‘S’, such that ‘T’ is a subsequence of ‘W’
//
//A subsequence is a sequence that can be derived from another sequence by removing zero or more elements, without changing the order.
//
//A substring is a contiguous part of a string.
//
//For example:
//For the given string “CodingNinjas”: “Ninja” is a substring while “dinas” is a subsequence.
//If there is no such Window in ‘S’ that covers all characters in ‘T’, return an empty string "". If there are multiple such minimum length windows, return the one with the smallest starting index.
public class MinWindowSubsequence {
    public static String minWindow(String S, String T) {
        // Write your code here

        if (T.isEmpty() || S.length() < T.length()) return "";
        String minWin = "";
        int j = 0;
        int min = S.length() + 1;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(j)) {
                j++;

                if (j >= T.length()) {
                    int end = i + 1;
                    j--;

                    while (j >= 0) {
                        if (S.charAt(i) == T.charAt(j)) {
                            j--;
                        }
                        i--;
                    }

                    i++;
                    j++;

                    if (end - i < min) {
                        min = end - i;
                        minWin = S.substring(i, end);
                    }
                }
            }
        }
        return minWin;

    }
}
