package STRIVERaTOz.Sorting;

public class selectionSort {
    public static void selection(int[] arr){
        for(int i=0; i<arr.length-2;i++){
            int min = i;
            for(int j=i;j<arr.length-1;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {

    }
}
