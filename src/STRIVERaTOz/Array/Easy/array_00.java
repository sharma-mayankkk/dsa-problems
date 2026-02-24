package STRIVERaTOz.Array.Easy;

//Check if the Array is Sorted II
public class array_00 {
    public static boolean checkSortedArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] >= arr[i - 1]) {
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,6,7,9,2};
        System.out.println(checkSortedArray(arr));;
    }
}
