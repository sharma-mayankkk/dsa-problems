package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNo {
    public static void solve(int index, String digit, StringBuilder temp, Map<Character, String> mp, List<String> ans) {
        if (index >= digit.length()) {
            ans.add(temp.toString());
            return;
        }

        char ch = digit.charAt(index);
        String str = mp.get(ch);

        for (int i = 0; i < str.length(); i++) {
            //do
            temp.append(str.charAt(i));
            solve(index + 1, digit, temp, mp, ans);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static List<String> letterCombination(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        List<String> ans = new ArrayList<>();
        Map<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        StringBuilder temp = new StringBuilder();
        solve(0, digits, temp, mp, ans);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(letterCombination("23"));
    }
}
