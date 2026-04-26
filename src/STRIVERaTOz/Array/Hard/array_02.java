package STRIVERaTOz.Array.Hard;

import java.util.*;

//3 Sum : Find triplets that add up to a zero
public class array_02 {
    //BruteForce Approach:
    public static List<List<Integer>> threeSum(int[] arr){
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    if(arr[i]+arr[j]+arr[k] == 0){
                        //storing sorted triplet to avoid duplicates;
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }
}
