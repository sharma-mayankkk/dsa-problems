package STRIVERaTOz.LinkedList;

public class LL_01_SearchElement {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    public boolean searchElement(Node head, int data){
        Node temp = head;

        while(temp != null) {
            if(temp.data == data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        LL_01_SearchElement ll = new LL_01_SearchElement();

        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        first.next = second;
        second.next = third;

        System.out.println(ll.searchElement(first,30));
    }
}
