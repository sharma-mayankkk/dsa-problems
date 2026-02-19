package STRIVERaTOz;
//Reverse an array
public class recursion_06 {
    public static void reverseArray(int[] arr, int l, int r){

        if(l>=r) return;
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        reverseArray(arr,l+1, r-1);
    }
    public static void printArr(int[] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reverseArray(arr,0,arr.length-1);
        printArr(arr);
    }
}
