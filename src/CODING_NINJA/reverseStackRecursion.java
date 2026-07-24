package CODING_NINJA;

import java.util.Stack;

//Problem statement
//Reverse a given stack of 'N' integers using recursion. You are required to make changes in the input parameter itself.
//
//
//
//Note: You are not allowed to use any extra space other than the internal stack space used due to recursion.
public class reverseStackRecursion {
    public static void insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        int top = st.pop();
        insertAtBottom(st, x);
        st.push(top);

    }

    public static void reverse(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();
        reverse(st);
        insertAtBottom(st, top);
    }
}
