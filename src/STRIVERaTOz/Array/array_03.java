package STRIVERaTOz.Array;

//Left Rotate Array by K Places
public class array_03 {

    //This is the bruteforce approach:
    public static void rotateArrBrute(int[] arr, int n, int k) {
        k %= n;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }

        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - (n - k)];
        }
    }

    //Optimal solution for it:
    // Optimal solution
    public static void rotateArr(int[] arr, int n, int k) {
        k = k % n;
        reverseArr(arr, 0, k-1);
        reverseArr(arr, k, n-1);
        reverseArr(arr, 0, n-1);
    }

    public static void reverseArr(int[] arr, int si, int ei) {
        while (si < ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;

            si++;
            ei--;
        }
    }

        public static void printArr ( int[] arr){
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }

        public static void main (String[]args){
            int[] arr = {1, 2, 3, 4, 5, 6};
            int n = arr.length;
            rotateArr(arr, n, 2);
            printArr(arr);
        }
    }
