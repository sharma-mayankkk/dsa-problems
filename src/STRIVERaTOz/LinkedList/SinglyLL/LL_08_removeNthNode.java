package STRIVERaTOz.LinkedList.SinglyLL;
//Remove N-th node from the end of a Linked List

//Problem Statement: Given a linked list and an integer N, the task is to delete the Nth node from the end of the linked list and print the updated linked list.
public class LL_08_removeNthNode {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //BruteForce approach:
    public static Node removeNthNode(Node head, int n) {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if (size == n) return head.next;

        temp = head;
        for (int i = 1; i < size - n; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    //optimal solution:
    public static Node removeNthNode2(Node head, int n) {
        Node fast = head, slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);
        Node sixth = new Node(60);
        Node seventh = new Node(70);

        Node head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        Node ans = removeNthNode2(head, 2);
        display(ans);
    }
}
