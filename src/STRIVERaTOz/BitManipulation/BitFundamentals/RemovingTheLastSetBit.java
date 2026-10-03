package STRIVERaTOz.BitManipulation.BitFundamentals;

public class RemovingTheLastSetBit {
    public static int removeLastSetBit(int n) {
        return (n & n - 1);
    }

    public static void main(String[] args) {
        System.out.println(removeLastSetBit(20));
    }
}
