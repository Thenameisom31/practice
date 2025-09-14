package LinkedList_Problem;

import java.util.Stack;

public class ReverseLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node reverseList(Node head) {
       Stack<Node> stack = new Stack<>();
       Node temp = head;
         while (temp != null) {
              stack.push(temp);
              temp = temp.next;
         }
         if(!stack.isEmpty())
         {
                head = stack.pop();
                temp = head;
                while (!stack.isEmpty()) {
                    temp.next= stack.pop();
                    temp = temp.next;
                }
                temp.next = null;
                
            }
            return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
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

        System.out.println("Original Linked List:");
        printList(head);

        head = reverseList(head);

        System.out.println("Reversed Linked List:");
        printList(head);
    }
    
}
