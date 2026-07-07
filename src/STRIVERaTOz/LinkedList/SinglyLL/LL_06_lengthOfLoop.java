package STRIVERaTOz.LinkedList.SinglyLL;

import java.util.HashMap;

public class LL_06_lengthOfLoop {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int lengthOfLoop(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        int timer = 1;
        Node temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                int value = map.get(temp);
                return timer - value;
            }
            map.put(temp, timer);
            timer++;
            temp = temp.next;
        }
        return 0;
    }

    //Optimal solution:
    public static int findLen(Node slow, Node fast) {
        fast = fast.next;
        int count = 1;
        while (slow != fast) {
            fast = fast.next;
            count++;
        }
        return count;
    }

    public static int lengthOfLoop2(Node head) {
        Node fast = head, slow = head;
        int count = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return findLen(slow, fast);
        }
        return 0;
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
        seventh.next = third;

        System.out.println(lengthOfLoop(head));
    }
}
