/* Find the first node of loop in linked list
Difficulty: MediumAccuracy: 55.49%Submissions: 89K+Points: 4
You are given the head of a singly linked list. If a loop is present in the linked list then return the first node of the loop else return -1.

Note: Internally, pos(1 based index) is used to denote the position of the node that tail's next pointer is connected to. If pos = 0, it means the last node points to null, indicating there is no loop. Note that pos is not passed as a parameter.

Examples: 
Input: head = [1,3,4], pos = 2
Output: 3
Input: head = [1,8,3,4], pos = 0
Output: -1

*/

package LinkedList_Problem;

class Node {

    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

}

public class FirstNodeInLoop {

    public static int firstNode(Node head) {
        Node slow = head;
        Node fast = head;

        // Detect loop using Floyd's Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow.data;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creating a loop for testing

        int result = firstNode(head);
        if (result != -1) {
            System.out.println("The first node of the loop is: " + result);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
