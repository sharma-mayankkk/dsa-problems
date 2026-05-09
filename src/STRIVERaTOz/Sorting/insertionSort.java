package STRIVERaTOz.Sorting;

//insertion Sort
public class insertionSort {
    public static void insertionShot(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 6, 2, 3, 1};
        insertionShot(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
