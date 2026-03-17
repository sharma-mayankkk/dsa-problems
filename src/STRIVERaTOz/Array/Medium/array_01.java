package STRIVERaTOz.Array.Medium;

//Sort an array of 0's 1's and 2's;
public class array_01 {
    //better solution:
    public static void sortArray(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i : arr) {
            if (i == 0) count0++;
            else if (i == 1) count1++;
            else count2++;
        }
        for (int i = 0; i < count0; i++) arr[i] = 0;
        for (int i = count0; i < count0 + count1; i++) arr[i] = 1;
        for (int i = count0+count1; i < arr.length; i++) arr[i] = 2;
    }
    //optimal solution:(Dutch national flag algorithm)
    public static void dnf(int[] arr){
        int low =0;
        int i = 0;
        int high = arr.length-1;

        while(i<=high){
            if(arr[i]==0){
                int temp = arr[low];
                arr[low] = arr[i];
                arr[i] = temp;
                low++;
                i++;
            } else if(arr[i]==2){
                int temp = arr[high];
                arr[high] = arr[i];
                arr[i] = temp;
                high--;
            }else i++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,0,0,1,2,0,1,1,0,2,2};
        dnf(arr);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}
