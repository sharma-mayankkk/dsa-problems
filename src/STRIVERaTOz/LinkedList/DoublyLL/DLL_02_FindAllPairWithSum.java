package STRIVERaTOz.LinkedList.DoublyLL;

import java.util.ArrayList;
import java.util.Arrays;

public class DLL_02_FindAllPairWithSum {
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

    //BruteForce solution:
    public static ArrayList<ArrayList<Integer>> findAllPairs(Node head, int sum) {
        Node temp1 = head;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while (temp1 != null) {
            Node temp2 = temp1.next;
            while (temp2 != null && temp1.data + temp2.data <= sum) {
                if (temp1.data + temp2.data == sum) {
                    ans.add(new ArrayList<>(Arrays.asList(temp1.data, temp2.data)));
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return ans;
    }

    //Optimal solution:
    public static ArrayList<ArrayList<Integer>> findAllPairs2(Node head, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node left = head, right = head;

        while (right.next != null) {
            right = right.next;
        }

        while (left.data < right.data) {
            if (left.data + right.data == sum) {
                ans.add(new ArrayList<>(Arrays.asList(left.data, right.data)));
                left = left.next;
                right = right.prev;
            } else if (left.data + right.data < sum) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        return ans;
    }
}
