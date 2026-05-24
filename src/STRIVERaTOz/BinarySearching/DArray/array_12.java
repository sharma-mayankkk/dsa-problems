package STRIVERaTOz.BinarySearching.DArray;

//
public class array_12 {
    //bruteforce method
    public static int singleAppearance(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            // First element
            if (i == 0) {
                if (arr[i] != arr[i + 1])
                    return arr[i];
            }
            // Last element
            else if (i == n - 1) {
                if (arr[i] != arr[i - 1])
                    return arr[i];
            }
            // Middle elements
            else {
                if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1])
                    return arr[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        System.out.println(singleAppearance(arr));
    }
}
