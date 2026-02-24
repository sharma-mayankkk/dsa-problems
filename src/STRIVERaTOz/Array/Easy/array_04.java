package STRIVERaTOz.Array.Easy;
//Problem Statement: You are given an array of integers, your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order.
public class array_04 {

    //Bruteforce approach:
    public static void moveZeroes(int[] arr, int n){
        int[] temp = new int[n];
        int k =0;

        //copying non-zero element in temp array
        for(int i: arr){
            if(i!=0){
                temp[k] = i;
                k++;
            }
        }

        //copy temp back to original array
        for(int i=0; i<k; i++){
            arr[i] = temp[i];
        }

        //filling last places with 0
        for(int i=k; i<n; i++){
            arr[i] = 0;
        }
    }

    //Optimal Solution:
    public static void moveZerosToLast(int[] arr, int n){
        int j = -1;
        for(int i=0; i<n; i++){
            if(arr[i] ==0){
                j = i;
                break;
            }
        }

        for(int i = j+1; i<n; i++){
            if(arr[i] !=0){
                int temp = arr[i];
                arr[i] =arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
    public static void printArr ( int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,5,7,0,0,8};
        moveZerosToLast(arr,arr.length);
        printArr(arr);
    }
}
