package STRIVERaTOz.BitManipulation.BitFundamentals;
//
//Check if the i-th bit is Set or Not
//Given two integers n and i, return true if the ith bit in the binary representation of n (counting from the least significant bit, 0-indexed) is set (i.e., equal to 1). Otherwise, return false.

public class ithBitSetOrNot {
    //by using left shift operator:
    public static boolean checkIthBitSetOrNot(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    //by using right shift operator:
    public static boolean checkIthBitSetOrNot2(int n, int i) {
        return ((n >> i) & 1) != 0;
    }

    public static void main(String[] args) {
        System.out.println(checkIthBitSetOrNot2(13, 2));
    }
}
