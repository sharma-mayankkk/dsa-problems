package LEETCODE;
//PS: Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//You must solve this problem without using the library's sort function.

public class leetCode_75 {
    public void sortColors(int[] nums) {
        int low=0, high=nums.length-1, i=0;
        while(i<=high){
            if(nums[i]==0){
                int temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                low++;
                i++;
            }else if(nums[i]==2){
                int temp = nums[high];
                nums[high] = nums[i];
                nums[i] = temp;
                high--;
            }else i++;
        }
    }
    public static void main(String[] args) {

    }
}
