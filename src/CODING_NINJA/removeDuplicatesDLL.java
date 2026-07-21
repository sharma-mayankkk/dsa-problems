package CODING_NINJA;

//Problem statement
//A doubly-linked list is a data structure that consists of sequentially linked nodes, and the nodes have reference to both the previous and the next nodes in the sequence of nodes.
//You are given a sorted doubly linked list of size 'n'.
//Remove all the duplicate nodes present in the linked list.
public class removeDuplicatesDLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node uniqueSortedList(Node head) {
        // Write your code here.
        Node temp = head;

        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;

            while (nextNode != null && temp.data == nextNode.data) {
                nextNode = nextNode.next;
            }

            temp.next = nextNode;
            temp = temp.next;
        }

        return head;
    }
}
