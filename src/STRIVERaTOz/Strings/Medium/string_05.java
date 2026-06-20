package STRIVERaTOz.Strings.Medium;

//Given a string s, return the longest palindromic substring in s.
public class string_05 {
    //BruteForce method:
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sb = s.substring(i, j + 1);
                if (isPalindrome(sb)) {
                    if (sb.length() > ans.length()) {
                        ans = sb;
                    }
                }
            }
        }
        return ans;
    }

    //Optimal solution:
    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }

    public static String longestPalindrome2(String s) {
        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            int oddLength = expand(s,i,i);
            int evenLength = expand(s,i,i+1);

            int currentLength = Math.max(oddLength, evenLength);

            if(currentLength>maxLength){
                maxLength = currentLength;
                start = i-(currentLength-1)/2;
            }
        }

        return s.substring(start,start+maxLength);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("abbbaa"));
    }
}
