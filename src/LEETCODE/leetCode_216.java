package LEETCODE;

import java.util.ArrayList;
import java.util.List;

//Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//
//Only numbers 1 through 9 are used.
//Each number is used at most once.
//Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
public class leetCode_216 {
    public void findCombination(List<List<Integer>> ans, List<Integer> combi, int start, int n, int k) {
        if (k == 0) {
            if (n == 0) {
                ans.add(new ArrayList<>(combi));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            combi.add(i);
            findCombination(ans, combi, i + 1, n - i, k - 1);
            combi.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combi = new ArrayList<>();

        findCombination(ans, combi, 1, n, k);

        return ans;
    }
}
