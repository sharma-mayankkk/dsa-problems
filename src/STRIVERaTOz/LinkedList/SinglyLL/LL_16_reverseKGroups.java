package STRIVERaTOz.LinkedList.SinglyLL;
//Reverse Linked List in groups of Size K

//Problem Statement: Given the head of a singly linked list containing integers, reverse the nodes of the list in groups of k and return the head of the modified list. If the number of nodes is not a multiple of k, then the remaining nodes at the end should be kept as is and not reversed.
//Do not change the values of the nodes, only change the links between nodes.
public class LL_16_reverseKGroups {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node findKthNode(Node temp, int k) {
        while (k > 1 && temp != null) {
            temp = temp.next;
            k--;
        }

        return (k == 1) ? temp : null;
    }

    public static Node reverse(Node head) {
        Node temp = head, prev = null;

        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    public static Node reverseK(Node head, int k) {
        Node temp = head, nextNode = null, prev = null;

        while (temp != null) {
            Node kThNode = findKthNode(temp, k);

            if (kThNode == null) {
                if (prev != null) prev.next = temp;
                break;
            }

            nextNode = kThNode.next;
            kThNode.next = null;
            reverse(temp);

            if (temp == head) {
                head = kThNode;
            } else {
                prev.next = kThNode;
            }

            prev = temp;
            temp = nextNode;
        }
        return head;
    }
}
