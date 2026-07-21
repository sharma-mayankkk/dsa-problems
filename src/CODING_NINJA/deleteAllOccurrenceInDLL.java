package CODING_NINJA;
//Problem statement
//A doubly-linked list is a data structure that consists of sequentially linked nodes, and the nodes have reference to both the previous and the next nodes in the sequence of nodes.
//You’re given a doubly-linked list and a key 'k'.

//Delete all the nodes having data equal to ‘k’.
public class deleteAllOccurrenceInDLL {
    static class Node {
        public int data;
        public Node next;
        public Node prev;

        Node() {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public static Node deleteAllOccurrences(Node head, int k) {
        // Write your code here.
        Node temp = head;

        while (temp != null) {
            if (temp.data == k) {
                if (temp == head) {
                    head = head.next;
                }

                Node nextNode = temp.next;
                Node prevNode = temp.prev;

                if (prevNode != null) prevNode.next = nextNode;
                if (nextNode != null) nextNode.prev = prevNode;

                temp = temp.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
