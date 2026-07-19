package LEETCODE;

public class leetCode_138 {

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

    class Solution {
        public static void insertInBetween(Node head) {
            Node temp = head;
            while(temp!=null){
                Node newNode = new Node(temp.val);
                newNode.next = temp.next;
                temp.next = newNode;
                temp = temp.next.next;
            }
        }

        public static void insertRandPointer(Node head) {
            Node temp = head;

            while(temp!=null){
                Node newNode = temp.next;

                if(temp.random!=null){
                    newNode.random = temp.random.next;
                }else{
                    newNode.random = null;
                }
                temp = temp.next.next;
            }
        }

        public static Node extractCopyLL(Node head) {
            Node dummy = new Node(-1), res = dummy, temp = head;

            while(temp!=null){
                res.next = temp.next;
                res = res.next;
                temp.next = temp.next.next;
                temp = temp.next;
            }

            return dummy.next;
        }

        public Node copyRandomList(Node head) {
            insertInBetween(head);
            insertRandPointer(head);
            return extractCopyLL(head);
        }
    }
}
