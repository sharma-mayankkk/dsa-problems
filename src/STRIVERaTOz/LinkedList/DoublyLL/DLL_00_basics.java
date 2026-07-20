package STRIVERaTOz.LinkedList.DoublyLL;

public class DLL_00_basics {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size = 0;

    //display forward direction
    public void DisplayForward(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
    }

    //Display backward direction:
    public void displayBackward(Node tail) {
        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.prev;
        }
    }

    //Insert at first:
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    //insert at the end:
    public void insertAtTheEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    //delete the beginning:
    public void deleteBeginning() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    //Delete from the end:
    public void deleteEnd() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    //Insert at the index:
    public void insertAtIndex(int data, int index) {
        Node newNode = new Node(data);

        if (index < 0 || index > size) return;

        if (index == 0) {
            insertAtBeginning(data);
            return;
        }

        if (index == size) {
            insertAtTheEnd(data);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
        newNode.next.prev = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            deleteBeginning();
            return;
        }

        if (index == size-1) {
            deleteEnd();
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        temp.next.prev = temp;

        size--;
    }


}
