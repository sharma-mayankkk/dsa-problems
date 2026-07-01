package STRIVERaTOz.LinkedList;

public class LL_01_Basics {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head and Tail
    Node head;
    Node tail;
    int size = 0;

    //traverse liked list to print:
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertAtFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;

        size--;
    }

    public int sizeOfLL() {
        return size;
    }

    public static void main(String[] args) {


        LL_01_Basics ll = new LL_01_Basics();
// raw method to create linked list:
//        //create nodes;
//        Node first = new Node(10);
//        Node second = new Node(20);
//        Node third = new Node(30);
//
//        //connecting nodes;
//        first.next = second;
//        second.next = third;
//
//        //assign head and tails
//
//        ll.head = first;
//        ll.tail = third;
//
//        ll.display();
        ll.insertAtFirst(10);
        ll.insertAtFirst(20);
        ll.insertAtFirst(30);


        ll.display();
        System.out.println(ll.sizeOfLL());
    }
}
