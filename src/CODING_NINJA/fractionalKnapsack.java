package CODING_NINJA;

import java.util.Arrays;

//Problem statement
//You have been given weights and values of ‘N’ items. You are also given a knapsack of size ‘W’.
//
//Your task is to put the items in the knapsack such that the total value of items in the knapsack is maximum.
//
//Note:
//You are allowed to break the items.
public class fractionalKnapsack {

    class Pair {
        int weight;
        int value;

        Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static double maximumValue(Pair[] items, int n, int w) {
        // Write your code here.
        // ITEMS contains {weight, value} pairs.
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double ans = 0;
        for (int i = 0; i < n; i++) {
            if (items[i].weight <= w) {
                ans += items[i].value;
                w -= items[i].weight;
            } else {
                ans += ((double) items[i].value / items[i].weight) * w;
                break;
            }
        }
        return ans;
    }
}
