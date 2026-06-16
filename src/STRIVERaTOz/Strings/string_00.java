package STRIVERaTOz.Strings;
//Remove Outermost Parentheses
//Problem Statement: A valid parentheses string is defined by the following rules:
//
//It is the empty string "".
//If A is a valid parentheses string, then so is "(" + A + ")".
//If A and B are valid parentheses strings, then A + B is also valid.
//
//A primitive valid parentheses string is a non-empty valid string that cannot be split into two or more non-empty valid parentheses strings.
//
//Given a valid parentheses string s, your task is to remove the outermost parentheses from every primitive component of s and return the resulting string.
public class string_00 {
    public static String removeOutermostParenthesis(String s){
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for(char ch: s.toCharArray()){
            if(ch==')'){
                count--;
            }

            if(count !=0){
                ans.append(ch);
            }

            if(ch=='('){
                count++;
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeOutermostParenthesis("((()))()()"));
    }
}
