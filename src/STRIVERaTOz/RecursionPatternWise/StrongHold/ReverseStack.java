package STRIVERaTOz.RecursionPatternWise.StrongHold;
import java.util.Stack;

public class ReverseStack {

    //Solving using extra space:
    public static void reverse2(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }

        int top = st.pop();
        reverse2(st);

        Stack<Integer> temp = new Stack<>();

        while(!st.isEmpty()){
            temp.push(st.pop());
        }
        st.push(top);

        while(!st.isEmpty()){
            st.push(temp.pop());
        }

    }
    // Insert an element at the bottom of the stack
    public static void insertAtBottom(Stack<Integer> st, int x) {
        // Base Case
        if (st.isEmpty()) {
            st.push(x);
            return;
        }
        int top = st.pop();
        insertAtBottom(st, x);
        st.push(top);
    }
    public static void reverse(Stack<Integer> st) {

        // Base Case
        if (st.isEmpty()) {
            return;
        }
        int top = st.pop();
        reverse(st);
        insertAtBottom(st, top);
    }
}
