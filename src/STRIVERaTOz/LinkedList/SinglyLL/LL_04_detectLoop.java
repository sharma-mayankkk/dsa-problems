package STRIVERaTOz.LinkedList.SinglyLL;

import java.util.HashMap;

public class LL_04_detectLoop {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //BruteForce method:
    public static boolean detectLoop(Node head) {
        HashMap<Node, Boolean> map = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }
            map.put(temp, true);
            temp = temp.next;
        }
        return false;
    }

    //Optimal solution:
    public static boolean detectLoop2(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
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

        System.out.println(detectLoop(head));
    }
}
