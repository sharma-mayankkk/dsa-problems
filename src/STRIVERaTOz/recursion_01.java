package STRIVERaTOz;
import java.util.Scanner;
//Print name N times using recursion
public class recursion_01 {
    public static void printName(int i, int n ){
        if(i>n) return;
        System.out.println("I am Batman.");
        printName(i+1, n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting number:");
        int i = sc.nextInt();

        System.out.println("Enter the Number of times:");
        int n = sc.nextInt();

        printName(i,n);
    }
}
