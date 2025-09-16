/* Merge two sorted linked lists

Given the head of two sorted linked lists consisting of nodes respectively. Merge both lists and return the head of the sorted merged list.

Examples:

Input: 
        10 -> 20 -> 30 -> 40 -> 50
        2 -> 3 -> 5 -> 15
  
Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40

   
Input:
    1 -> 2 -> 4
    1 -> 3 -> 5
  
Output: 1 -> 1 -> 2 -> 4

   */

package LinkedList_Problem;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortedLists {

    public Node Merge(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node dummy = new Node(-1);
        Node curr = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if (head1 != null) {
            curr.next = head1;
        }
        else {
            curr.next = head2;
        }
       

        return dummy.next;
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
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = new Node(50);

        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(15);

        MergeSortedLists list = new MergeSortedLists();
        Node mergedHead = list.Merge(head1, head2);
        printList(mergedHead);
    }

}
      
 
