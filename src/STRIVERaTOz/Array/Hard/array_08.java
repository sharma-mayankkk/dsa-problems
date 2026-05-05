package STRIVERaTOz.Array.Hard;

import java.util.ArrayList;
//Count inversions in an array
//Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).
public class array_08 {

    //BruteForce solution:
    public static int countInversion(int[] arr){
        int count = 0;
        for(int i = 0; i<arr.length;i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i]>arr[j]) count++;
            }
        }
        return count;
    }

    //Optimal solution:

    public static int merge(ArrayList<Integer> arr, int left, int mid, int right){
        ArrayList<Integer> temp = new ArrayList<>();
        int i = left;
        int j = mid+1;
        int count = 0;
        while(i<=mid && j<=right){
            if(arr.get(i)<=arr.get(j)){
                temp.add(arr.get(i));
                i++;
            }else{
                temp.add(arr.get(j));
                count+=(mid-i+1);
                j++;
            }
        }

        //left half:
        while(i<=mid){
            temp.add(arr.get(i++));
        }
        //right half:
        while(j<=right){
            temp.add(arr.get(j++));
        }

        //copy back to original array:
        for(int k =0; k<temp.size(); k++){
            arr.set(left + k, temp.get(k));
        }
        return count;
    }
    public static int mergeSort(ArrayList<Integer> arr, int low, int high){
       int count = 0;
        if(low>=high) return count;
        int mid = (low+high)/2;

        count += mergeSort(arr,low,mid);
        count += mergeSort(arr,mid+1,high);
        count += merge(arr, low, mid, high);
        return count;
    }

    //optimal code for the number of inversion:
    public static int countInversion2(ArrayList<Integer> arr){
        int n = arr.size();
        return mergeSort(arr,0,n-1);

    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.add(1);
        System.out.println(countInversion2(arr));
    }
}
