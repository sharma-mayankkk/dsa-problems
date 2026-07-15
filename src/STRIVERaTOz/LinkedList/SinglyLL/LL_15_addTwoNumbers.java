package STRIVERaTOz.LinkedList.SinglyLL;
//Add two numbers represented as Linked Lists

//Problem Statement: Add two numbers represented as Linked Lists.
public class LL_15_addTwoNumbers {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addTwoNumbers(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        int carry = 0;

        while (head1 != null || head2 != null || carry != 0) {
            int sum = 0;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            if (head2 != null) {
                sum += head2.data;
                head1 = head2.next;
            }

            sum += carry;
            Node newNode = new Node(sum % 10);
            carry = sum / 10;
            temp.next = newNode;
            temp = temp.next;
        }

        return dummy.next;
    }

}
