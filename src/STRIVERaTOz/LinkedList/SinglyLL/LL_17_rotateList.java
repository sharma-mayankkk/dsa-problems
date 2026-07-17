package STRIVERaTOz.LinkedList.SinglyLL;
//Rotate a Linked List

//Problem Statement: Given the head of a singly linked list containing integers, shift the elements of the linked list to the right by k places and return the head of the modified list. Do not change the values of the nodes, only change the links between nodes.
public class LL_17_rotateList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node findKthNode(Node head, int k) {
        Node temp = head;
        while (k > 1) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public static Node kRotation(Node head, int k) {
        if (head == null || k == 0) return head;

        int len = 1;
        Node tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        if (k % len == 0) return head;

        k = k % len;

        tail.next = head;
        Node kthNode = findKthNode(head, len - k);
        head = kthNode.next;
        kthNode.next = null;

        return head;
    }
}
