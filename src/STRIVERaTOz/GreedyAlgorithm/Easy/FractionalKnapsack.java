package STRIVERaTOz.GreedyAlgorithm.Easy;
import java.util.Arrays;

//You have n items; the i-th item has value val[i] and weight wt[i].
//
//A knapsack can carry at most capacity units of weight.
//
//You may take any fraction of an item (i.e. split items).
//
//Return the maximum total value that can be placed in the knapsack, rounded to exactly 6 decimal places.
public class FractionalKnapsack {
    public static double fractionalKnapsack(int[] val, int[] weight, long cap) {
        //storing sorted indices based on the ratio
        Integer[] arr = new Integer[val.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        Arrays.sort(arr, (a, b) -> Double.compare((double) val[b] / weight[b], (double) val[a] / weight[a]));

        double ans = 0;
        for (Integer i : arr) {
            if (weight[i] <= cap) {
                ans += val[i];
                cap -= weight[i];
            } else {
                ans += ((double) val[i] / weight[i]) * cap;
                cap = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] val = {100, 60, 120};
        int[] weight = {20, 10, 30};
        System.out.println(fractionalKnapsack(val,weight,50));
    }
}
