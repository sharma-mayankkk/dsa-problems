package CODING_NINJA;
//Problem statement
//You’re given a linked list. The last node might point to null, or it might point to a node in the list, thus forming a cycle.
//
//Find out whether the linked list has a cycle or not, and the length of the cycle if it does.
//If there is no cycle, return 0, otherwise return the length of the cycle.
public class find_length_of_loop_LL {
    class Node {
        public int data;
        public Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static int findLen(Node slow, Node fast){
        int count = 1;
        fast = fast.next;
        while(slow!=fast){
            fast = fast.next;
            count++;
        }
        return count;
    }
    public static int lengthOfLoop(Node head) {
        // Write your code here
        Node fast = head, slow = head;
        while(fast!=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) return findLen(slow,fast);
        }

        return 0;
    }

}
