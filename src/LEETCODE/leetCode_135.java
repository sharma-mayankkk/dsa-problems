package LEETCODE;

//There are n children standing in a line.
//
//Each child is assigned a rating value given in the integer array ratings.
//
//You are giving candies to these children subjected to the following requirements:
//
//Each child must have at least one candy.
//Children with a higher rating get more candies than their neighbors.
//Return the minimum number of candies you need to have to distribute the candies to the children.
public class leetCode_135 {
    public int candy(int[] ratings) {
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
}
