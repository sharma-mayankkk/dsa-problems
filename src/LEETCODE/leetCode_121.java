package LEETCODE;
//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
public class leetCode_121 {
    public int maxProfit(int[] prices) {
        int min = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {

    }
}
