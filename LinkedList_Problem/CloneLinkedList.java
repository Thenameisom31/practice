/* Clone List with Next and Random
Difficulty: HardAccuracy: 64.8%Submissions: 117K+Points: 8
You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node of the singly linked list, and a random pointer that points to the random node of the linked list.

Construct a copy of this linked list. The copy should consist of the same number of new nodes, where each new node has the value corresponding to its original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list, such that it also represent the same list state. None of the pointers in the new list should point to nodes in the original list.

Return the head of the copied linked list.

NOTE : Original linked list should remain unchanged.
Each node of the linked list is represented as a pair of [val, random_index] where:

val represents node.data.
random_index (1-based index) represents the index of the node that the random pointer of the current node points to, or NULL if it does not point to any node. 
Examples: 
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
*/
package LinkedList_Problem;

class Node {
    int data;
    Node next, random;

    Node(int d) {
        data = d;
        next = random = null;
    }
}

public class CloneLinkedList {

    static public Node cloneLinkedList(Node head) {
        // code here
        Node curr = head;
        if (curr == null) {
            return null;
        }
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node cloneHead = head.next;
        Node clone = cloneHead;
        while (clone != null && clone.next != null) {
            curr.next = curr.next.next;
            clone.next = clone.next.next;
            curr = curr.next;
            clone = clone.next;
        }
        if (clone != null)
            clone.next = null;
        if (curr != null)
            curr.next = null;
        return cloneHead;

    }
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "(");
            if (head.random != null) {
                System.out.print(head.random.data);
            } else {
                System.out.print("null");
            }
            System.out.print(")");
            
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;
        System.out.println("Original linked list:");
        printList(head);
        
        Node clonedList = cloneLinkedList(head);
        
        System.out.println("Cloned linked list:");
        printList(clonedList);
        
       
    }
}