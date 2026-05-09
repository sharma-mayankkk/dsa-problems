package STRIVERaTOz.Sorting;

public class bubbleSort {
    public static void bubbleShot(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j <= i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 6, 2, 3, 1};
        bubbleShot(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
