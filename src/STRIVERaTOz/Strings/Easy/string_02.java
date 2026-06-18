package STRIVERaTOz.Strings.Easy;

//Largest odd substring in string.
//You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
//A substring is a contiguous sequence of characters within a string.
public class string_02 {
    public static String largestOdd(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                return s.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "3577834656";
        System.out.println(largestOdd(s));
    }
}
