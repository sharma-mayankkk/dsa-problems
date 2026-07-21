package STRIVERaTOz.LinkedList.DoublyLL;
//Delete all occurrences of a key in DLL
//Problem Statement: Given the head of a doubly linked list and an integer target. Delete all nodes in the linked list with the value target and return the head of the modified linked list.
//

public class DLL_01_DeleteAllOccurrences {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node deleteOccurrence(Node head, int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                if (temp == head) {
                    head = head.next;
                }
                Node nextNode = temp.next;
                Node prev = temp.prev;

                if (nextNode != null) nextNode.prev = prev;
                if (prev != null) prev.next = nextNode;

                temp = temp.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}
