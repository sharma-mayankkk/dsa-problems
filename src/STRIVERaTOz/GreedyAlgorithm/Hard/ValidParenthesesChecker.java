package STRIVERaTOz.GreedyAlgorithm.Hard;

//Find the validity of an input string s that only contains the letters '(', ')' and '*'.
//
//A string entered is legitimate if
//
//Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//Any right parenthesis ')' must have a corresponding left parenthesis '('.
//Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
public class ValidParenthesesChecker {
    public static boolean validParentheses(String s, int idx, int count) {
        if (count < 0) return false;
        if (idx == s.length()) {
            return count == 0;
        }

        if (s.charAt(idx) == '(') return validParentheses(s, idx + 1, count + 1);
        if (s.charAt(idx) == ')') return validParentheses(s, idx + 1, count - 1);

        return validParentheses(s, idx + 1, count + 1) ||
                validParentheses(s, idx + 1, count - 1) ||
                validParentheses(s, idx + 1, count);
    }

    //optimal solution:
    public static boolean checkValidParentheses(String s) {
        int min = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                min += 1;
                max += 1;
            } else if (s.charAt(i) == ')') {
                min -= 1;
                max -= 1;
            } else {
                min -= 1;
                max += 1;
            }
            if (max < 0) return false;
            if (min < 0) min = 0;

        }
        return min == 0;
    }

    public static void main(String[] args) {

    }
}
