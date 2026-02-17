package STRIVERaTOz;

//Understand recursion by print something N times:
public class recursion_00 {
    static int count =0;
    public static void setCount(){
        if(count ==5) return;
        System.out.println(count);
        count++;
        setCount();
    }
    public static void main(String[] args) {
        setCount();
    }
}
