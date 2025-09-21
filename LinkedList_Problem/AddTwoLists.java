/* Add Number Linked Lists
Difficulty: MediumAccuracy: 34.52%Submissions: 358K+Points: 4Average Time: 30m
You are given the head of two singly linked lists head1 and head2 representing two non-negative integers. You have to return the head of the linked list representing the sum of these two numbers.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples: 
Input: head1 = [2,4,3], head2 = [5,6,4]
Output: [7,0,8]


*/
package LinkedList_Problem;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class AddTwoLists {

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;

    }

    public Node addTwoLists(Node head1, Node head2) {
        // code here
        head1 = reverse(head1);
        head2 = reverse(head2);

        int carry = 0;
        Node sum = null;
        while (head1 != null || head2 != null || carry > 0) {
            int newVal = carry;
            if (head1 != null) {
                newVal += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                newVal += head2.data;
                head2 = head2.next;
            }

            carry = newVal / 10;
            newVal %= 10;

            Node newNode = new Node(newVal);
            newNode.next = sum;
            sum = newNode;

        }

        while (sum != null && sum.data == 0) {
            sum = sum.next;
        }

        return (sum == null) ? new Node(0) : sum;

    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        AddTwoLists ad = new AddTwoLists();
        Node result = ad.addTwoLists(head1, head2);
        printList(result); // Output: 7 -> 0 -> 8
    }
}