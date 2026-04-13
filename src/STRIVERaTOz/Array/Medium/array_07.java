package STRIVERaTOz.Array.Medium;

//Longest Consecutive Sequence in an Array
//Problem Statement: Given an array nums of n integers.
//Return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class array_07 {
    public static boolean linearSearch(int[] arr, int target){
       for(int i: arr){
           if(i==target) return true;
       }
       return false;
    }

    //BruteForce solution;
    public static int longestSequence(int[] arr){
        int longest =1;
        for(int i: arr){
            int x = i;
            int count = 1;
            while(linearSearch(arr, x + 1)){
                x=x+1;
                count+=1;
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }

    //Better Solution:
    public static int longestSeq(int[] arr){
        Arrays.sort(arr);
        int longest = 1, currCount = 0, lastSmaller = Integer.MIN_VALUE;
        for(int i: arr){
            if(i-1 == lastSmaller){
                currCount+=1;
                lastSmaller = i;
            } else if (i != lastSmaller) {
                currCount = 1;
                lastSmaller = i;
            }
            longest = Math.max(longest,currCount);
        }

        return longest;
    }
    //Optimal solution:(incomplete)

//    public static int longestSequence2(int[] arr){
//        if(arr.length ==0) return 0;
//        int longest = 1;
//        Set<Integer> st = new HashSet<>();
//
//        for(int i = 0; i<arr.length; i++){
//
//        }
//    }
    public static void main(String[] args) {
        int[] arr ={1,2,7,1,1,2,2,4,9,8,3};
        System.out.println(longestSeq(arr));
    }
}
