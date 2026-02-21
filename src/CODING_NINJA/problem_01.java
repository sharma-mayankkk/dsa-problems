package CODING_NINJA;
//Problem statement
//Given an array 'arr' containing 'n' elements, rotate this array left once and return it.
//Rotating the array left by one means shifting all elements by one place to the left and moving the first element to the last position in the array.
public class problem_01 {
    static int[] rotateArray(int[] arr, int n) {
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
        return arr;
    }

    public static void main(String[] args) {
    }
}
