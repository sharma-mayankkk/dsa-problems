package LEETCODE;

//Given the head of a singly linked list, reverse the list, and return the reversed list.
public class leetCode_206 {
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

    //iterative:
    public ListNode reverseList(ListNode head) {
        ListNode temp = head, prev = null;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    //recursive:
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList2(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
}
