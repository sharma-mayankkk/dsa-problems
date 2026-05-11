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

    //recursive bubble sort:
    static void recursiveBubbleSort(int[] arr, int n) {

        // Base case
        if (n == 1) {
            return;
        }

        // One pass of bubble sort
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {

                // Swap elements
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Recursive call for remaining array
        recursiveBubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 6, 2, 3, 1};
        bubbleShot(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
