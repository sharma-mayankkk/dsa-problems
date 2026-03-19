package STRIVERaTOz.Array.Medium;

//Stock Buy and Sell
public class array_03 {
    public static int maxProfit(int[] arr) {
        int min = arr[0], maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            int cost = arr[i] - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, arr[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }
}
