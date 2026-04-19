package STRIVERaTOz.Array.Medium;
// subarray with sum k:
import java.util.HashMap;
import java.util.Map;

public class array_10 {
    //BruteForce approach O(n^3)
    public static int noSubArrayWithSumK(int[] arr, int kSum){
        int count = 0;
        int n = arr.length;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum+=arr[k];
                }
                if(sum== kSum) count++;
            }
        }
        return count;
    }

    //Better solution: TC around O(n^2):
    public static int noSubArrayWithSumK2(int[] arr, int kSum){
        int count = 0;
        int n = arr.length;

        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum+=arr[j];
                if(sum== kSum) count++;
            }
        }
        return count;
    }

    //Optimal solution:
    public static int noSubArrayWithSumK3(int[] arr, int k){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0;
        int count =0;

        for(int i: arr){
            preSum+=i;
            if(map.containsKey(preSum-k)){
                count+=map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(noSubArrayWithSumK3(arr,7));
    }
}
