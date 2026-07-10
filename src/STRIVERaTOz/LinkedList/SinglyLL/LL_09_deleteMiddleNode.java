package STRIVERaTOz.LinkedList.SinglyLL;

public class LL_09_deleteMiddleNode {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //BruteForce method:
    public static Node deleteMiddleNode(Node head) {
        if (head == null || head.next == null) return null;

        Node temp = head;
        int size = 0;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        temp = head;
        for (int i = 1; i < size / 2; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
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

    //Optimal solution:
    public static Node deleteMiddleNode2(Node head) {
        if (head == null || head.next == null) return null;

        Node fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);
        Node sixth = new Node(60);
//        Node seventh = new Node(70);

        Node head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
//        sixth.next = seventh;

        display(deleteMiddleNode2(head));
    }
}
