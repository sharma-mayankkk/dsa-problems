package LEETCODE;
//Write a function that reverses a string. The input string is given as an array of characters s.

//You must do this by modifying the input array in-place with O(1) extra memory.
public class leetCode_344 {
    public void reverseString(char[] s) {
        int low = 0, high = s.length - 1;

        while (low <= high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;

            low++;
            high--;
        }
    }
}
