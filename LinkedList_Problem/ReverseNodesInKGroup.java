/* Linked List Group Reverse
Difficulty: HardAccuracy: 57.08%Submissions: 265K+Points: 8Average Time: 30m
You are given the head of a Singly linked list. You have to reverse every k node in the linked list and return the head of the modified list.
Note: If the number of nodes is not a multiple of k then the left-out nodes at the end, should be considered as a group and must be reversed.

Examples:

Input: k = 2, Linked List = 1 -> 2 -> 3 -> 4 -> 5 -> 6  
Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
Input: k = 3, Linked List = 1 -> 2 -> 3 -> 4 -> 5 -> 6  
Output: 3 -> 2 -> 1 -> 6 -> 5 -> 4 */
package LinkedList_Problem;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseNodesInKGroup {

    /*
     * class Node
     * {
     * int data;
     * Node next;
     * Node(int key)
     * {
     * data = key;
     * next = null;
     * }
     * }
     */

    class Solution {
        public Node reverseKGroup(Node head, int k) {
            // code here
            Node curr = head;
            Node next = curr.next;
            Node newHead = null;
            Node tail = null;
            Node GroupHead = null;
            while (curr != null) {
                GroupHead = curr;
                int count = 0;
                Node prev = null;
                while (curr != null && count < k) {
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                    count++;
                }
                if (newHead == null) {
                    newHead = prev;
                }
                if (tail != null) {
                    tail.next = prev;
                }
                tail = GroupHead;
            }

            return newHead;

        }
    }
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Original Linked List:");
        printList(head);

        int k = 2;
        ReverseNodesInKGroup list = new ReverseNodesInKGroup();
        Solution sol = list.new Solution();
        head = sol.reverseKGroup(head, k);

        System.out.println("Reversed Linked List in groups of " + k + ":");
        printList(head);
    }
}