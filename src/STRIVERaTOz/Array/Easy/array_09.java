package STRIVERaTOz.Array.Easy;

//Find Maximum consecutive ones in the array:
public class array_09 {
    public static int maxConOnes(int[] arr) {
        int max = 0;
        int count = 0;

        for (int i : arr) {
            if (i == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1};
        System.out.println(maxConOnes(arr));
    }
}
