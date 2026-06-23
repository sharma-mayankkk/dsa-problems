package STRIVERaTOz.Strings.Hard;
//Minimum number of bracket reversals needed to make an expression balanced

//Problem Statement: Given a string s consisting of only opening and closing brackets '(' and ')', find out the minimum number of reversals required to convert the string into a balanced expression.
//
//If it is not possible to make the brackets balanced, return -1. A reversal means changing '(' to ')' or vice versa.
public class string_00 {
    public static int minAddToMakeValid(String s) {
        int count = 0;
        int opening = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            if (ch == ')' && count > 0) {
                count--;
            } else if (ch == ')' && count == 0) {
                opening++;
            }
        }
        return count + opening;
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("))(("));
    }
}
