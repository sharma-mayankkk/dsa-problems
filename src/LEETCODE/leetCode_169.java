package LEETCODE;

//PS: Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
public class leetCode_169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = 0;
        for (int i : nums) {
            if (count == 0) {
                count = 1;
                ele = i;
            } else if (ele == i) {
                count++;
            } else count--;
        }
        int newCount = 0;
        for (int i : nums) {
            if (i == ele) newCount++;
        }
        if (newCount > (nums.length / 2)) return ele;
        return -1;
    }
}
