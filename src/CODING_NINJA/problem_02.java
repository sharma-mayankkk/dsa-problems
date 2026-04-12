package CODING_NINJA;
//You are given an array arr of positive integers. Your task is to find all the leaders in the array. An element is considered a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader.
import java.util.*;
public class problem_02 {
    static ArrayList<Integer> leaders(int arr[]) {
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] >= max){
                ans.add(arr[i]);
                max = arr[i];
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
