package LEETCODE;
//Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.
public class leetCode_1614 {
    public int maxDepth(String s) {
        int count = 0;
        int ans = 0;

        for(char ch: s.toCharArray()){
            if(ch=='('){
                count++;
                ans = Math.max(count,ans);
            }else if(ch==')'){
                count--;
            }
        }
        return ans;
    }
}
