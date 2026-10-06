package CODING_NINJA;
//Problem statement
//You are given two numbers 'L' and 'R'.
//Find the XOR of the elements in the range [L, R].
//For Example:
//For 'L' = 1 and ‘R’ = 5.
//The answer is 1.
public class LtoRxor {
    public static int xorInaRange(int n) {
        if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n + 1;
        else if (n % 4 == 3) return 0;

        return n;
    }
    public static int findXOR(int L, int R){
        // Write your code here.
        return xorInaRange(L-1)^xorInaRange(R);
    }
}
