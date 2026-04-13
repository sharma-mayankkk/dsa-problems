package STRIVERaTOz.Array.Medium;

//Longest Consecutive Sequence in an Array
//Problem Statement: Given an array nums of n integers.
//Return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.

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
    public static void main(String[] args) {
        int[] arr ={1,2,7,4,9,8,3};
        System.out.println(longestSequence(arr));
    }
}
