package STRIVERaTOz.StackAndQueue.Implementation;

public class StackUsingArrays {
    private int[] stack;
    private int top;
    private int capacity; 

    public StackUsingArrays(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    // Push: Insert an element
    public void push(int data) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        stack[++top] = data;
    }

    // Pop: Remove and return the top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return stack[top--];
    }

    // Top: Return the top element without removing it
    public int top() {
        if (isEmpty()) {
            return -1;
        }

        return stack[top];
    }

    // isEmpty: Check whether stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
    }
}
