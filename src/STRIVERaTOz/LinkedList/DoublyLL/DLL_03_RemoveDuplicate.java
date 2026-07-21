package STRIVERaTOz.LinkedList.DoublyLL;

public class DLL_03_RemoveDuplicate {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node removeDuplicates(Node head) {
        Node temp = head;

        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;

            while (nextNode != null && nextNode.data == temp.data){
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if(nextNode !=null ) nextNode.prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
