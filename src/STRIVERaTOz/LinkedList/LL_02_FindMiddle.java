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

    //Bruteforce approach:
     static Node findMiddle(Node head){
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

    //Optimal solution:
     static Node findMiddle2(Node head){

        Node fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);
        Node sixth = new Node(60);
        Node seventh = new Node(70);

        Node head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;


        Node ans = findMiddle2(first);
        System.out.println(ans.data);
    }
}
