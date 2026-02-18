package STRIVERaTOz;

//Print N to 1 using Recursion
import java.util.Scanner;
public class recursion_03 {
    public static void printNtoI(int i){
        if(i<1)return;
        System.out.println(i);
        printNtoI(i-1);
    }
    public static void main(String[] args){
        printNtoI(5);
    }
}
