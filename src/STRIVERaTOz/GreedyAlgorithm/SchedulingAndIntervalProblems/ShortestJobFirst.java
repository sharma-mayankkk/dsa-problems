package STRIVERaTOz.GreedyAlgorithm.SchedulingAndIntervalProblems;

import java.util.Arrays;

//A software engineer is tasked with using the shortest job first (SJF) policy to calculate the average waiting time for each process. The shortest job first also known as shortest job next (SJN) scheduling policy selects the waiting process with the least execution time to run next.
//
//You are given an array of integers bt of size n representing the burst times (execution times) of n processes.
//
//Your task is to calculate the average waiting time for all processes when scheduled using the SJF policy. The waiting time of a process is the total time a process has to wait before its execution starts, which is the sum of burst times of all previously executed processes.
//
//Return the floor of the average waiting time, i.e., the largest whole number less than or equal to the actual average.
public class ShortestJobFirst {
    public static int sjf(int[] bt) {
        Arrays.sort(bt);

        int t = 0, wt = 0;
        for (int i : bt) {
            wt += t;
            t += i;
        }
        return wt / bt.length;
    }

    public static void main(String[] args) {
        System.out.println(sjf(new int[]{4,3,7,1,2}));
    }
}
