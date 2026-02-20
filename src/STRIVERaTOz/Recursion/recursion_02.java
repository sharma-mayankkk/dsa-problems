package STRIVERaTOz.Recursion;
import java.util.Scanner;
//Print 1 to N using Recursion:

public class recursion_02 {
    public static void print1ToN(int i, int n){
        if(i>n) return;
        System.out.println(i);
        print1ToN(i+1,n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First number:");
        int i = sc.nextInt();
        System.out.println("Enter the value of N");
        int n = sc.nextInt();
        print1ToN(i,n);
    }
}
