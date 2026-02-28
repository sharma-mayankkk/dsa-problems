package STRIVERaTOz.Array.Medium;
import java.util.*;
//Two Sum : Check if a pair with given sum exists in Array
public class array_00 {

    //Bruteforce method
    public static boolean twoSum(int[] arr, int target){
        for (int i = 0; i < arr.length ; i++) {
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]+arr[j]==target) return true;
            }
        }
        return false;
    }
    public static int[] TwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {

            int moreNeeded = target - nums[i];
            // Check first
            if(map.containsKey(moreNeeded)) {
                return new int[]{map.get(moreNeeded), i};
            }
            // Then store
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(twoSum(arr,11));
    }
}
