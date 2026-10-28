package STRIVERaTOz.SlidingWindow_TwoPointers.LongestAndSmallestWinProb;

//ou are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
//Return the length of the longest substring containing the same letter you can get after performing the above operations.
//Example 1:
//
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.
public class LongestRepeatingCharacterReplacement {
    public static int longestCharReplacement(String s, int k) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                hash[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);
                int changes = (j - i + 1) - maxFreq;
                if (changes <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else break;
            }
        }
        return maxLen;
    }

    //Sliding Window Technique:
    public static int longestCharReplacement2(String s, int k) {
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;

        int[] hash = new int[26];
        while (r < s.length()) {
            int charIndex = s.charAt(r) - 'A';
            hash[charIndex]++;
            maxFreq = Math.max(maxFreq, hash[charIndex]);
            while ((r - l + 1) - maxFreq > k) {
                hash[s.charAt(l) - 'A']--;
                maxFreq = 0;
                for (int i : hash) maxFreq = Math.max(maxFreq, i);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static int longestCharReplacement3(String s, int k) {
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;

        int[] hash = new int[26];
        while (r < s.length()) {
            int charIndex = s.charAt(r) - 'A';
            hash[charIndex]++;
            maxFreq = Math.max(maxFreq, hash[charIndex]);
            if ((r - l + 1) - maxFreq > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestCharReplacement3("AABABBA", 1));
    }
}
