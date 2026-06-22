package LEETCODE;

//The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
//For example, the beauty of "abaacc" is 3 - 1 = 2.
//Given a string s, return the sum of beauty of all of its substrings.
public class leetCode_1781 {
    public int beautySum(String s) {
        int n = s.length();
        int beauty = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int maxFreq = Integer.MIN_VALUE;

            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'a';
                freq[index]++;

                maxFreq = Math.max(maxFreq, freq[index]);
                int minFreq = Integer.MAX_VALUE;

                for (int k : freq) {
                    if (k > 0) {
                        minFreq = Math.min(minFreq, k);
                    }
                }
                beauty += (maxFreq - minFreq);
            }
        }
        return beauty;
    }
}
