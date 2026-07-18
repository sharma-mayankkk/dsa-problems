package CODING_NINJA;
//Problem statement
//You are given a linked list containing 'n' 'head' nodes, where every node in the linked list contains two pointers:

//(1) ‘next’ which points to the next node in the list
//
//(2) ‘child’ pointer to a linked list where the current node is the head.

//Each of these child linked lists is in sorted order and connected by 'child' pointer.
//
//Your task is to flatten this linked such that all nodes appear in a single layer or level in a 'sorted order'.
public class flatten_LL {
    static class Node {
        public int data;
        public Node next;
        public Node child;

        Node() {
            this.data = 0;
            this.next = null;
            this.child = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }

        Node(int data, Node next, Node child) {
            this.data = data;
            this.next = next;
            this.child = child;
        }
    }

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

    public static Node flattenLinkedList(Node head) {
        //Write your code here

        if (head == null || head.next == null) return head;

        Node mergedHead = flattenLinkedList(head.next);
        return merge(head, mergedHead);
    }

}
