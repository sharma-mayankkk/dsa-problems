package STRIVERaTOz.GreedyAlgorithm.Easy;

//Given an array of integers nums, each element in the array represents the maximum jump length at that position. Initially starting at the first index of the array, determine if it is possible to reach the last index. Return true if the last index can be reached, otherwise return false.
public class JumpGameI {
    public static boolean jumpGame1(int[] jump) {
        int maxIndex = 0;
        for (int i = 0; i < jump.length; i++) {
            if (i > maxIndex) return false;
            maxIndex = Math.max(maxIndex, jump[i] + i);
            if (maxIndex >= jump.length - 1) return true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(jumpGame1(new int[]{2, 3, 1, 0, 4}));
    }
}
