package STRIVERaTOz.RecursionPatternWise.AllCombosHard;
//Given a string s partition string s such that every substring of partition is palindrome. Return all possible palindrome partition of string s.

//Example 1:
//Input : s = "baa"
//
//Output : [ [ "b", "a", "a"] , [ "b", "aa" ] ]
//
//Explanation : Above all are the possible ways in which the string can be partitioned so that each substring is a palindrome.
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
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
    public static void getAllParts(String s,List<String> partition, List<List<String>> ans){
        if (s.isEmpty()){
            ans.add(new ArrayList<>(partition));
            return;
        }

        for (int i=0;i<s.length(); i++){
            String part = s.substring(0,i+1);
            if (isPalindrome(part)){
                partition.add(part);
                getAllParts(s.substring(i+1), partition, ans);
                partition.removeLast();
            }
        }
    }
    public static List<List<String>> partition(String s){
        List<List<String>> ans = new ArrayList<>();
        List<String> partition = new ArrayList<>();

        getAllParts(s,partition,ans);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
