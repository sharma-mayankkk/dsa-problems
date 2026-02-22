package STRIVERaTOz.Array;

public class array_05 {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 55, 11};
        System.out.println(linearSearch(arr, 11));
        ;
    }
}
