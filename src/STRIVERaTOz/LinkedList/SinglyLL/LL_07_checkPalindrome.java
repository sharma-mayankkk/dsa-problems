package STRIVERaTOz.LinkedList.SinglyLL;

import java.util.Stack;

public class LL_07_checkPalindrome {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean checkPalindrome(Node head) {
        Stack<Integer> st = new Stack<>();
        Node temp = head;

        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while (!st.isEmpty()) {
            if (st.pop() != temp.data) return false;
            temp = temp.next;
        }

        return true;
    }

    //Optimal solution:
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

    public static boolean isPalindrome(Node head) {
        Node fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverse(slow.next);

        Node first = head, second = newHead;
        while (second != null) {
            if (first.data != second.data) {
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverse(newHead);
        return true;
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(30);
        Node sixth = new Node(20);
        Node seventh = new Node(10);

        Node head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        System.out.println(checkPalindrome(head));
    }
}
