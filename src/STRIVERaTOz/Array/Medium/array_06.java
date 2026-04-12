package STRIVERaTOz.Array.Medium;

import java.util.ArrayList;

//Leaders in an Array
public class array_06 {
    public static ArrayList<Integer> leadersArr(int[] arr){
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] >max){
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {8,7,6,9,11,2,1};
        ArrayList<Integer> result = leadersArr(arr);
        for(int i: result){
            System.out.print(i+" ");
        }
    }
}
