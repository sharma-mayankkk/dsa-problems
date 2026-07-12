package STRIVERaTOz.LinkedList.SinglyLL;
//Sort a Linked List of 0's 1's and 2's by changing links

//Problem Statement: Given a linked list containing only 0's, 1's, and 2's, sort the linked list by rearranging the links (not by changing the data values).
public class LL_11_sort0s1s2s {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //Bruteforce:
    public static Node sort(Node head) {
        Node temp = head;
        int c0 = 0, c1 = 0, c2 = 0;

        while (temp != null) {
            if (temp.data == 0) {
                c0++;
            } else if (temp.data == 1) {
                c1++;
            } else {
                c2++;
            }
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (c0 != 0) {
                temp.data = 0;
                c0--;
            } else if (c1 != 0) {
                temp.data = 1;
                c1--;
            } else {
                temp.data = 2;
                c2--;
            }

            temp = temp.next;
        }
        return head;
    }

    //optimal solution:
    public static Node sortLL(Node head) {
        if (head == null || head.next == null) return head;

        Node temp = head;
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead, one = oneHead, two = twoHead;

        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }

            temp = temp.next;
        }


        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }

    public static void main(String[] args) {

    }
}
