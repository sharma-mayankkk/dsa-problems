package STRIVERaTOz.Array.Easy;
//Find the missing number in the array optimal solution with two approaches.
public class array_08 {

    //Optimal solution with total sum method:
    public static int missingNumber(int[] arr,int n){
        int nSum = (n*(n+1))/2;
        int arrSum = 0;
        for(int i:arr){
            arrSum+=i;
        }

        return nSum-arrSum;
    }
    //since the sum method would not be better for the large integers we have XOR method:
    public static int returnMissing(int[] arr, int n){
        int xor1 =0;
        int xor2 =0;

        for(int i=1; i<=n; i++){
            xor1 ^= i;
        }
        for(int i: arr){
            xor2 ^= i;
        }
        return xor1^xor2;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6};
        System.out.println(returnMissing(arr,6));
    }
}
