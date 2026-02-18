package STRIVERaTOz;
//Factorial of a given number
public class recursion_05 {
    public static int factorial(int n){
        if(n==0 || n==1 ) return 1;
        return n*factorial(n-1);
    }
    public static void main(String[] args){
        System.out.println(factorial(3));
    }
}
