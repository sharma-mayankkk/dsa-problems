package CODING_NINJA;
//Problem statement
//You have been given two arrays, 'AT' and 'DT', representing the arrival and departure times of all trains that reach a railway station.
//
//Your task is to find the minimum number of platforms required for the railway station so that no train needs to wait.
//
//Note :
//1. Every train will depart on the same day and the departure time will always be greater than the arrival time. For example, A train with arrival time 2240 and departure time 1930 is not possible.
//
//2. Time will be given in 24H format and colons will be omitted for convenience. For example, 9:05AM will be given as "905", or 9:10PM will be given as "2110".
//
//3. Also, there will be no leading zeroes in the given times. For example, 12:10AM will be given as “10” and not as “0010”.

import java.util.Arrays;

public class minimumNoOfPlatform {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // Write your code here.
        Arrays.sort(at);
        Arrays.sort(dt);
        int count = 0, maxCount = 0;

        int i = 0, j = 0;

        while (i < n && j < n) {
            if (at[i] <= dt[j]) {
                count++;
                i++;
                maxCount = Math.max(maxCount, count);
            } else {
                count--;
                j++;
            }
        }

        return maxCount;
    }
}
