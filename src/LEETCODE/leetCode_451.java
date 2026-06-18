package LEETCODE;

import java.util.*;

//Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
//Return the sorted string. If there are multiple answers, return any of them.
public class leetCode_451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();

        for (char ch : s.toCharArray()) {
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        int n = s.length();

        List<Character>[] bucket = new ArrayList[n + 1];

        for (Map.Entry<Character, Integer> entry : mpp.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(ch);
        }

        StringBuilder sb = new StringBuilder();

        for (int freq = n; freq >= 1; freq--) {
            if (bucket[freq] != null) {
                for (char ch : bucket[freq]) {
                    for (int i = 0; i < freq; i++) {
                        sb.append(ch);
                    }
                }
            }
        }

        return sb.toString();
    }
}
