package STRIVERaTOz.LinkedList.SinglyLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LL_18_flatteningLL {
    static class Node {
        int data;
        Node next;
        Node child;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    //optimal solution:
    public static Node merge(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node res = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                res.child = l1;
                res = res.child;
                l1 = l1.child;
            } else {
                res.child = l2;
                res = res.child;
                l2 = l2.child;
            }
            res.next = null;
        }

        if (l1 != null) {
            res.child = l1;
        } else {
            res.child = l2;
        }

        return dummy.child;
    }

    public static Node flattenLL(Node head) {
        if (head == null || head.next == null) return head;

        Node mergedHead = flattenLL(head.next);
        return merge(head, mergedHead);
    }

    //BruteForce:
    public static Node convert(List<Integer> list) {
        if (list.isEmpty()) return null;

        Node head = new Node(-1);
        Node temp = head;

        for (int i : list) {
            temp.child = new Node(i);
            temp = temp.child;
        }

        return head.child;
    }

    public static Node flattenLinkedList(Node head) {
        List<Integer> list = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            Node t2 = temp;

            while (t2 != null) {
                list.add(t2.data);
                t2 = t2.child;
            }

            temp = temp.next;
        }

        Collections.sort(list);

        return convert(list);
    }
}
