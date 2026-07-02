package STRIVERaTOz.LinkedList;

public class LL_00_Basics {

    //create a node:
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

    //Insert at first position:
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

    //Insert at last positon:
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

    //Delete head of the linked list
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

    //Delete tail of the linkedList
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

    //calculate the size of the linked list:
    public int sizeOfLL() {
        return size;
    }

    //Insert at particular index in linked list:
    public void insertAtIndex(int index, int data) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == size) {
            insertAtLast(data);
            return;
        }

        if (index == 0) {
            insertAtFirst(data);
            return;
        }

        Node newNode = new Node(data);

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == size-1) {
            deleteLast();
            return;
        }

        if (index == 0) {
            deleteFirst();
            return;
        }

        Node temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    public static void main(String[] args) {

        LL_00_Basics ll = new LL_00_Basics();
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
        ll.insertAtLast(40);
        ll.insertAtLast(50);
        ll.insertAtIndex(3,60);

        ll.display();
        System.out.println(ll.sizeOfLL());
    }
}
