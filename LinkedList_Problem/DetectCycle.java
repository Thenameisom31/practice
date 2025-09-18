/* Detect Cycle in Linked List

comments
Given the head of a singly linked list, determine whether the list contains a cycle.

A cycle exists if, while traversing the list through next pointers, you encounter a node that has already been visited instead of eventually reaching nullptr.

Examples:

Input: head: 1 -> 3 -> 4 -> 3
Output: true */
package LinkedList_Problem;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class DetectCycle {

    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer by 1 step
            fast = fast.next.next;     // Move fast pointer by 2 steps

            if (slow == fast) {        // Cycle detected
                return true;
            }
        }

        return false; 
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creating a cycle for testing

        System.out.println("Does the linked list have a cycle? " + hasCycle(head));
    }
}

