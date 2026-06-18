package STRIVERaTOz.Strings.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Sort characters by frequency
//Problem Statement: You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.
//If two or more characters have same frequency then arrange them in alphabetic order.
public class string_00 {
    public static String sortCharacters(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();

        //count frequency:
        for (char ch : s.toCharArray()) {
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        //convert map into the list for sorting
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(mpp.entrySet());

        //sort the list in the descending order:
        list.sort((a, b) -> b.getValue() - a.getValue());

        //make answer now :
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int freq = entry.getValue();

            for (int i = 0; i < freq; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String sortCharacters2(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();

        for (char ch : s.toCharArray()) {
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        int n = s.length();

        //create a bucket where character will be stored at the index of their frequency
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

    public static void main(String[] args) {
        System.out.println(sortCharacters2("aabcccaaaaaaaaa"));
    }
}
