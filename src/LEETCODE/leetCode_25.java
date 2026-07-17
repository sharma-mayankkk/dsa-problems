package LEETCODE;

//Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
//
//k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
//
//You may not alter the values in the list's nodes, only nodes themselves may be changed.
//
//
public class leetCode_25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode findKthNode(ListNode temp, int k) {
        while (k > 1 && temp != null) {
            temp = temp.next;
            k--;
        }

        return (k == 1) ? temp : null;
    }

    public static ListNode reverse(ListNode head) {
        ListNode temp = head, prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, nextNode = null, prev = null;

        while (temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                if (prev != null) prev.next = temp;
                break;
            }

            nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);

            if (temp == head) {
                head = kthNode;
            } else {
                prev.next = kthNode;
            }

            prev = temp;
            temp = nextNode;
        }
        return head;
    }
}
