package STRIVERaTOz.Strings.Medium;

import java.util.HashSet;

//Given a string s consisting only of characters a, b and c.
//Return the number of substrings containing at least one occurrence of all these characters a, b and c.
public class string_04 {
    //BruteForce approach:
    public static int countSubstring(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[3];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a'] = 1;
                if (freq[0] + freq[1] + freq[2] == 3) {
                    count += s.length() - j;// bcs at a point if it consists all three char then next substring will be also containing all;
                    break;
                }
            }
        }
        return count;
    }

    //Optimal solution:
    public static int countSubstring2(String s) {
        int count = 0;
        int[] lastSeen = {-1, -1, -1};


        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;

            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstring2("abcabc"));
    }
}
