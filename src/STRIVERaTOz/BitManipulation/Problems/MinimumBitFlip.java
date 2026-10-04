package STRIVERaTOz.BitManipulation.Problems;

//Given two integers start and goal. Flip the minimum number of bits of start integer to convert it into goal integer.
//
//A bits flip in the number val is to choose any bit in binary representation of val and flipping it from either 0 to 1 or 1 to 0.
public class MinimumBitFlip {
    public static int minBitFlip(int start, int goal) {
        int temp = start ^ goal;
        int count = 0;
        while (temp != 0) {
            count += temp & 1;
            temp = temp >> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minBitFlip(10,7));
    }
}
