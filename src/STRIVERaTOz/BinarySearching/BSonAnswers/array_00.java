package STRIVERaTOz.BinarySearching.BSonAnswers;
//Problem Statement: You are given a positive integer n. Your task is to find and return its square root. If ‘n’ is not a perfect square, then return the floor value of sqrt(n).
public class array_00 {
    public static int findSqrt(int n){
        int low =1, high = n, ans=0;

        while(low<=high){
            int mid = (low+high)/2;
            if(mid*mid<=n){
                ans=mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(findSqrt(349));
    }
}
