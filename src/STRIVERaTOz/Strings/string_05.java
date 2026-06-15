package STRIVERaTOz.Strings;

//Check if one string is rotation of another
//Problem Statement: Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
//A shift on s consists of moving the leftmost character of s to the rightmost position. For example, if s = "abcde", then it will be "bcdea" after one shift.
public class string_05 {
    //BruteForce solution:

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (s.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    //Optimal solution:
    public static boolean rotateString2(String s, String goal) {
        if (s.length() != goal.length()) return false;

        //logic: combine the string itself twice: s+s then it will always contain a valid goal;
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdecb";
        System.out.println(rotateString2(s, goal));
    }
}
