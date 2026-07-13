package STRIVERaTOz.LinkedList.SinglyLL;

import java.util.HashMap;
import java.util.Map;

public class LL_12_findIntersection {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //BruteForce method:
    public static Node findIntersection(Node head1, Node head2) {
        Node temp = head1;
        Map<Node, Integer> map = new HashMap<>();

        while (temp != null) {
            map.put(temp, 1);
            temp = temp.next;
        }

        temp = head2;

        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    //Better Solution:
    public static Node findCollision(Node smaller, Node greater, int distance) {
        Node t1 = smaller, t2 = greater;
        while (distance != 0) {
            t2 = greater.next;
            distance--;
        }

        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1;
    }

    public static Node getIntersection(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        Node t1 = head1, t2 = head2;
        int n1 = 0, n2 = 0;

        while (t1 != null) {
            n1++;
            t1 = t1.next;
        }

        while (t2 != null) {
            n2++;
            t2 = t2.next;
        }

        if (n1 > n2) {
            return findCollision(head2, head1, n1 - n2);
        } else if (n1 < n2) {
            return findCollision(head1, head2, n2 - n1);
        } else return null;
    }

    //Optimal solution:
    public static Node getIntersection2(Node head1, Node head2) {
        Node t1 = head1, t2 = head2;

        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;

            if (t1 == t2) return t1;

            if (t1 == null) t1 = head2;
            if (t2 == null) t2 = head1;
        }

        return t1;
    }
}
