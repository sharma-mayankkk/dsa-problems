package STRIVERaTOz.Array.Easy;

//Longest subarray with given sum K(positives)
public class array_13 {
    //Bruteforce approach:
    public static int subArray(int[] arr, int sum){
        int len =0;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int s =0;
                for(int k=i; k<=j; k++){
                    s+=arr[k];
                }
                if(s==sum) len=Math.max(len,j-i+1);
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,7,8,9,2,5};
        System.out.println(subArray(arr,13));
    }
}
