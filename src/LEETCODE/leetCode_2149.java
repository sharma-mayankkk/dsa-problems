package LEETCODE;
//You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
//
//You should return the array of nums such that the array follows the given conditions:
//
//Every consecutive pair of integers have opposite signs.
//For all integers with the same sign, the order in which they were present in nums is preserved.
//The rearranged array begins with a positive integer.
public class leetCode_2149 {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];

        int posIndex =0, negIndex=1;
        for(int i: nums){
            if(i>0){
                ans[posIndex] = i;
                posIndex+=2;
            }else{
                ans[negIndex] = i;
                negIndex+=2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
