package STRIVERaTOz.LinkedList.SinglyLL;
//Sort a Linked List

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem Statement: Given a linked list, sort its nodes based on the data value in them. Return the head of the sorted linked list.
public class LL_10_sortLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //BruteForce method:
    public static Node sort(Node head) {
        Node temp = head;
        List<Integer> list = new ArrayList<>();

        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(list);

        temp = head;
        int i = 0;
        while (temp != null) {
            temp.data = list.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }

    //optimal solution:

    public static Node findMiddle(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static Node merge(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node t1 = list1, t2 = list2, temp = dummy;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        if (t1 != null) temp.next = t1;
        else temp.next = t2;

        return dummy.next;
    }

    public static Node sortLL(Node head) {
        if (head == null || head.next == null) return head;

        Node middle = findMiddle(head);
        Node leftHead = head;
        Node rightHead = middle.next;
        middle.next = null;

        leftHead = sortLL(leftHead);
        rightHead = sortLL(rightHead);

        return merge(leftHead, rightHead);

    }

    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(20);
        Node second = new Node(70);
        Node third = new Node(40);
        Node fourth = new Node(10);
        Node fifth = new Node(30);
        Node sixth = new Node(60);
        Node seventh = new Node(50);

        Node head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        display(sort(head));
    }
}
