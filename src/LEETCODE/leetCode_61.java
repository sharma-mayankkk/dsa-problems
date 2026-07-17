package LEETCODE;

//Given the head of a linked list, rotate the list to the right by k places.
public class leetCode_61 {
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

    public static ListNode findKthNode(ListNode head, int k) {
        ListNode temp = head;
        while (k > 1) {
            temp = temp.next;
            k--;
        }

        return temp;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int len = 1;
        ListNode tail = head;

        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        if (k % len == 0) return head;

        k = k % len;

        tail.next = head;
        ListNode newLast = findKthNode(head, len - k);
        head = newLast.next;
        newLast.next = null;

        return head;
    }
}
