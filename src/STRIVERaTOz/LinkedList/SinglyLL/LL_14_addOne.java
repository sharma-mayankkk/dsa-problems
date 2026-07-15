package STRIVERaTOz.LinkedList.SinglyLL;
//Add 1 to a number represented by LL

//Problem Statement: Given the head of a singly linked list representing a positive integer number. Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on. The task is to add one to the value represented by the linked list and return the head of a linked list containing the final value.
//
//The number will contain no leading zeroes except when the value represented is zero itself.
public class LL_14_addOne {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //Iterative solution:
    public static Node reverse(Node head) {
        Node temp = head, prev = null;

        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static Node addOne(Node head) {
        head = reverse(head);
        Node temp = head;
        int carry = 1;

        while (temp != null) {
            temp.data = temp.data + carry;

            if (temp.data < 10) {
                carry = 0;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }

            temp = temp.next;
        }

        if (carry == 1) {
            Node newNode = new Node(1);
            head = reverse(head);
            newNode.next = head;
            return newNode;
        }

        return reverse(head);
    }

    //recursive Solution:
    public static int findCarry(Node temp){
        if(temp == null) return 1;
        int carry = findCarry(temp.next);

        temp.data += carry;

        if(temp.data<10){
            return 0;
        }

        temp.data = 0;
        return 1;
    }
    public static Node addOne2(Node head){
        int carry = findCarry(head);

        if(carry == 1){
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }

        return head;
    }
}
