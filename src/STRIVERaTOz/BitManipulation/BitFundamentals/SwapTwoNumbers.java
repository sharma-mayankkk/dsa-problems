package STRIVERaTOz.BitManipulation.BitFundamentals;
//Given two integers a and b, swap them in-place using only 2 variables (without using a temporary variable).
//
//Can you solve it using:
//
//Arithmetic operations?
//Bitwise XOR?
public class SwapTwoNumbers {
    public static void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
    public static void main(String[] args) {

    }
}
