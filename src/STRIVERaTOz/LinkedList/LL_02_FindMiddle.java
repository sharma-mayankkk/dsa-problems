package STRIVERaTOz.LinkedList;

public class LL_02_FindMiddle {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node findMiddle(Node head){
        Node temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }

        int mid = (count/2);
        temp = head;
        for (int i = 0; i < mid ; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        Node head = first;
        first.next = second;
        second.next = third;

        Node ans = findMiddle(first);
        System.out.println(ans.data);
    }
}
