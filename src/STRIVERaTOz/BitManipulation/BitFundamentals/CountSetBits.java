package STRIVERaTOz.BitManipulation.BitFundamentals;

public class CountSetBits {
    public static int countOnes(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1) count++;
            n /= 2;
        }
        return count;
    }

    //another method:
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }

    //another method
    public static int countSetBits2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits2(12));
    }
}
