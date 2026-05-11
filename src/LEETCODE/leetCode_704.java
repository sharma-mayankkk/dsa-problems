package LEETCODE;
//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
//You must write an algorithm with O(log n) runtime complexity.
public class leetCode_704 {
    public int search(int[] nums, int target) {
        int si = 0, ei=nums.length-1;
        for(int i=0; i<nums.length; i++){
            int mid = (si+ei)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                ei= mid-1;
            }else{
                si=mid+1;
            }
        }
        return -1;
    }
}
