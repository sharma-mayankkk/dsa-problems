package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetTwo {
    public static void getAllSubset(int[] arr, List<List<Integer>> ans, int i, List<Integer> subset) {
        if (i == arr.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(arr[i]);
        getAllSubset(arr, ans, i + 1, subset);

        subset.removeLast();

        int index = i + 1;
        while (index < arr.length && arr[index] == arr[index - 1]) { //skipping duplicate value
            index++;
        }

        getAllSubset(arr, ans, index, subset);
    }

    public static List<List<Integer>> subset2(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        getAllSubset(arr, ans, 0, subset);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(subset2(arr));
    }
}
