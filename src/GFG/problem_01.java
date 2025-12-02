package GFG;
//Given an array of positive integers arr[], return the second-largest element from the array.
// If the second-largest element doesn't exist then return -1.
//Note: The second largest element should not be equal to the largest element.
public class problem_01 {
    public static int getSecondLargest(int[] arr) {
        // code here
        int largest = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }

        int sLargest = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>sLargest && arr[i] != largest){
                sLargest = arr[i];
            }
        }

        return sLargest;
    }
    public static void main(String[] args) {
        int arr[] = {10,10,10,10};
        System.out.println(getSecondLargest(arr));
    }
}
