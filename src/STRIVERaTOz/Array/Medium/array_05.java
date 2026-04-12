package STRIVERaTOz.Array.Medium;

//next_permutation : find next lexicographically greater permutation
public class array_05 {
    public static int[] nextPermutation(int[] arr) {
        int n = arr.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverseArray(arr, 0, n - 1);
            return arr;
        }
        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }

        reverseArray(arr, index + 1, n - 1);

        return arr;
    }

    public static void reverseArray(int[] arr, int l, int r) {

        if (l >= r) return;
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        reverseArray(arr, l + 1, r - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 1, 0, 0};
        nextPermutation(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
