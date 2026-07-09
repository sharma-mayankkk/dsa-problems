package STRIVERaTOz.LinkedList.SinglyLL;
//Segregate even and odd nodes in LinkedList

import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

//Problem Statement: Given the head of a singly linked list. Group all the nodes with odd indices followed by all the nodes with even indices and return the reordered list. Consider the 1st node to have index 1 and so on. The relative order of the elements inside the odd and even group must remain the same as the given input.
public class LL_08_oddEven {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node segregateOddEven(Node head) {
        if (head == null || head.next == null) return head;
        Node temp = head;
        List<Integer> list = new ArrayList<>();

        //copy the odd elements:
        while (temp != null && temp.next != null) {
            list.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) {
            list.add(temp.data);
        }

        //copy the even elements:
        temp = head.next;
        while (temp != null && temp.next != null) {
            list.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) list.add(temp.data);

        temp = head;
        for (Integer i : list) {
            temp.data = i;
            temp = temp.next;
        }

        return head;
    }

    //Optimal solution:
    public static Node oddEven(Node head){
        if(head==null || head.next == null) return head;

        Node odd = head, even = head.next, evenHead = head.next;

        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next.next;
        }
        odd.next = evenHead;

        return head;
    }
}
