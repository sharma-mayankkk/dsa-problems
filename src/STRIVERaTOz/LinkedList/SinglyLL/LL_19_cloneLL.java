package STRIVERaTOz.LinkedList.SinglyLL;

import java.util.HashMap;
import java.util.Map;

//Clone Linked List with Random and Next Pointer
//
//Problem Statement: Given a linked list where every node in the linked list contains two pointers:
//
//‘next’ which points to the next node in the list.
//‘random’ which points to a random node in the list or ‘null’.
//Create a ‘deep copy’ of the given linked list and return it.
public class LL_19_cloneLL {
    static class Node {
        int data;
        Node next;
        Node rand;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.rand = null;
        }
    }

    //Bruteforce solution:
    public static Node copyLL(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            Node newNode = new Node(temp.data);
            map.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.rand = map.get(temp.rand);

            temp = temp.next;
        }
        return map.get(head);
    }

    //Optimal solution:
    public static void insertInBetween(Node head) {
        Node temp = head;
        //insert in between;
        while (temp != null) {
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
    }

    public static void insertRandPointer(Node head) {
        //random pointer:
        Node temp = head;

        while (temp != null) {
            Node copyNode = temp.next;
            if (temp.rand != null) {
                copyNode.rand = temp.rand.next;
            } else {
                copyNode.rand = null;
            }
            temp = temp.next.next;
        }
    }

    public static Node extractCopyLL(Node head) {
        Node dummy = new Node(-1), res = dummy, temp = head;

        while (temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;

            temp = temp.next;
        }
        return dummy.next;
    }

    public static Node copyLL2(Node head) {
        insertInBetween(head);
        insertRandPointer(head);
        return extractCopyLL(head);
    }
}
