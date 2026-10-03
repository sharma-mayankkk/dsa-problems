package STRIVERaTOz.BitManipulation.BitFundamentals;

public class ClearTheIthBit {
    public static int clearTheIthBit(int n, int i){
        return (n & ~(1<<i));
    }
    public static void main(String[] args) {
        System.out.println(clearTheIthBit(13,2));
    }
}
