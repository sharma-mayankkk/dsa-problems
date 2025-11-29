package CODING_NINJA;

public class problem_00 {

    public static boolean armstrongNumber(int n) {
        int orignal = n; // to store the original value for the comparison.

        int temp = n;
        int count =0;
        while(temp>0){
            temp /=10;
            count++;
        }

        temp = n;// bcs the temp became 0 while counting
        int sum =0;
        while(temp>0){
            int lastDigit = temp%10;
            sum+= (int)Math.pow(lastDigit, count);
            temp /=10;
        }
        return(sum == orignal);
    }

    public static void main(String[] args) {
        System.out.println(armstrongNumber(153));
    }
}
