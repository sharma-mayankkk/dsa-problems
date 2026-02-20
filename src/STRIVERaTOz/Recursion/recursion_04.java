package STRIVERaTOz.Recursion;

//Sum of First N Numbers:
public class recursion_04 {
    //Parameterized recursion:
    public static void addition(int n, int sum){
        if(n<0){
            System.out.println(sum);
            return;
        }
        sum+=n;
        addition(n-1,sum);
    }
    //Functional recursion:
    public static int add(int n){
        if(n==0){
            return 0;
        }
        return n+add(n-1);
    }
    public static void main(String[] args){
        System.out.println(add(5));
    }
}
