package STRIVERaTOz.StackAndQueue.Implementation;

public class QueueUsingArrays {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    public QueueUsingArrays(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    // Check if queue is full
    public boolean isFull() {
        return rear == capacity - 1;
    } 


    // Insert element
    public void enqueue(int data) {

        if (isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }

        rear++;
        queue[rear] = data;

        System.out.println(data + " inserted");
    }

    // Remove element
    public void dequeue() {

        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return;
        }

        System.out.println(queue[front] + " removed");
        front++;

        if (front > rear) {
            front = 0;
            rear = -1;
        }
    }

    // Get front element
    public int peek() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queue[front];
    }

}
