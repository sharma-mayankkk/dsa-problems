package STRIVERaTOz.BinarySearching.DArray;

//
public class array_12 {
    //bruteforce approach
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

    //optimal solution:

    public static int singleAppearance2(int[] arr){
        int n = arr.length;
        if(n ==1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-1]!=arr[n-2]) return arr[n-1];

        int low = 1 , high = n-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]!= arr[mid-1] && arr[mid]!=arr[mid+1]) return arr[mid];

            //eliminated the left half
            if(mid%2 == 1 && arr[mid]==arr[mid-1] || mid%2==0 && arr[mid]==arr[mid+1]){
                low = mid+1;
            }else {
                high = mid-1; //eliminated the right half.
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        System.out.println(singleAppearance2(arr));
    }
}
