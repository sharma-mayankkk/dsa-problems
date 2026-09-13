package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;

//Combination Sum III
//Problem Statement: Determine all possible set of k numbers that can be added together to equal n while meeting the following requirements:
//1. There is only use of numerals 1 through 9.
//2. A single use is made of each number.
//Return list of every feasible combination that is allowed. The combinations can be returned in any order, but the list cannot have the same combination twice.
public class CombinationSumThree {

    public static void findCombination(List<List<Integer>> ans, List<Integer> combi, int start, int n, int k) {
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

