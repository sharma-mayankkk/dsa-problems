package STRIVERaTOz.SlidingWindow_TwoPointers.CountingSubarrOrSubstringProb;

//Given a string s , consisting only of characters 'a' , 'b' , 'c'.Find the number of substrings that contain at least one occurrence of all these characters 'a' , 'b' , 'c'.
//
//Example 1:
//Input : s = "abcba"
//
//Output : 5
//
//Explanation : The substrings containing at least one occurrence of the characters 'a' , 'b' , 'c' are "abc" , "abcb" , "abcba" , "bcba" , "cba".
//
//Example 2:
//Input : s = "ccabcc"
//
//Output : 8
//Explanation : The substrings containing at least one occurrence of the characters 'a' , 'b' , 'c' are "ccab" , "ccabc" , "ccabcc" , "cab" , "cabc" , "cabcc" , "abc" , "abcc".
public class NoOfSubstringWithAllThreeChars {
    //BruteForce solution:
    public static int subsWithAllThreeChars(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[3];
            for (int j = i; j < s.length(); j++) {
                hash[s.charAt(j) - 'a'] = 1;
                if (hash[0] + hash[1] + hash[2] == 3) {
                    count = s.length() - j;
                    break;
                }
            }
        }
        return count;
    }

    //optimal solution:
    public static int subWithAllThreeChars2(String s) {
        int count = 0;
        int[] lastSeen = {-1, -1, -1};

        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subWithAllThreeChars2("bbacba"));
    }
}
