package STRIVERaTOz.Array.Easy;

public class array_01 {

    public static int removeDuplicates(int[] arr) {
        int i = 0;
        for(int j = 1; j < arr.length; j++){
            if(arr[i] != arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i + 1;
    }

    public static void printArr(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 9, 9};
        int newLen = removeDuplicates(arr);
        printArr(arr, newLen);
    }
}