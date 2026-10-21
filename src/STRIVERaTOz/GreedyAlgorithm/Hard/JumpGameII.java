package STRIVERaTOz.GreedyAlgorithm.Hard;

//You are given a 0-indexed array nums of length n representing your maximum jump capability from each index.
//
//You start at index 0. Each element nums[i] represents the maximum number of steps you can jump forward from index i.
//
//Your goal is to reach the last index of the array (nums[n - 1]) using the minimum number of jumps.
//
//Return the minimum number of jumps required to reach the last index.
//
//You can assume that it is always possible to reach the last index.
public class JumpGameII {
    //recursive approach
    public static int solve(int[] arr, int index, int jumps) {
        if (index >= arr.length - 1) return jumps;
        int mini = Integer.MAX_VALUE;

        for (int i = 1; i < arr[index]; i++) {
            mini = Math.min(mini, solve(arr, index + i, jumps + 1));
        }
        return mini;
    }

    public static int jumpGame2(int[] arr) {
        return solve(arr, 0, 0);
    }

    //optimal approach: (greedy)
    public static int jumpGame(int[] jumps) {
        int n = jumps.length;
        int jump = 0, l = 0,r = 0;
        while (r < n-1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(i + jumps[i], farthest);
            }
            l = r + 1;
            r = farthest;
            jump++;
        }
        return jump;
    }

    public static void main(String[] args) {
        System.out.println(jumpGame(new int[]{2,3,1,1,4}));
    }
}
