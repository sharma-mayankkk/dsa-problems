package STRIVERaTOz.GreedyAlgorithm.Hard;

import java.util.Arrays;

//A line of N kids is standing there. The rating values listed in the integer array ratings are assigned to each kid.
//
//These kids are receiving candy, according to the following criteria:
//
//There must be at least one candy for every child.
//Kids whose scores are higher than their neighbors receive more candies than their neighbors.
//Return the minimum number of candies needed to distribute among children.
//
//Example 1:
//Input : ratings = [1, 0, 5]
//
//Output : 5
//
//Explanation : The distribution of candies will be 2 , 1 , 2 to first , second , third child respectively.
public class Candy {
    public static int candyDistribution(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = Math.max(candies[i], candies[i - 1] + 1);
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int ans = 0;
        for (int i : candies) {
            ans += i;
        }

        return ans;
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int sum = 1, i = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak += 1;
                sum += peak;
                i++;
            }

            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                down += 1;
                i++;
            }

            if (peak < down) {
                sum += down - peak;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(candyDistribution(new int[]{1, 2, 10, 10, 10, 2, 1}));
    }
}
