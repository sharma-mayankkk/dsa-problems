package CODING_NINJA;

public class add_one_to_LL {

    static class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public class Solution {
        public static int findCarry(Node temp) {
            if (temp == null) return 1;

            int carry = findCarry(temp.next);
            temp.data += carry;

            if (temp.data < 10) {
                return 0;
            }

            temp.data = 0;
            return 1;
        }

        public static Node addOne(Node head) {
            // Write your code here.
            int carry = findCarry(head);

            if (carry == 1) {
                Node newNode = new Node(1);
                newNode.next = head;
                return newNode;
            }

            return head;
        }

    }
}
