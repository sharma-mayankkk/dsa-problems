package STRIVERaTOz.BitManipulation.Problems;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> powerSet(int[] arr) {
        int subset = 1 << arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int n = 0; n < subset; n++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if ((n & (1 << j)) != 0) {
                    list.add(arr[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(powerSet(new int[]{1,2,3}));
    }
}
