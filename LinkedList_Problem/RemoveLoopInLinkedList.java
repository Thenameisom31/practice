/* Remove loop in Linked List
Difficulty: MediumAccuracy: 27.66%Submissions: 534K+Points: 4Average Time: 45m
Given the head of a singly linked list, the task is to remove a cycle if present. A cycle exists when a node's next pointer points back to a previous node, forming a loop. Internally, a variable pos denotes the index of the node where the cycle starts, but it is not passed as a parameter. The terminal will print true if a cycle is removed otherwise, it will print false.

Examples:

Input: head = 1 -> 3 -> 4, pos = 2
Output: true
Input: head = 1 -> 2 -> 3 -> 4, pos = -1
Output: false
 */
package LinkedList_Problem;
/*
class Node
{
    int data;
    Node next;
}
*/
class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;
        next=null;
    }
}

class Solution {
    public static void removeLoop(Node head) {
       
        Node fast=head;
        Node slow=head;
        
        
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                break;
            }
            
        }
        if(slow==fast)
        {
            slow=head;
            if(slow!=fast)
            {
                while(slow.next!=fast.next)
                {
                    slow=slow.next;
                    fast=fast.next;
                }
                fast.next=null;
            }
            else
            {
                while(fast.next!=slow)
                {
                    fast=fast.next;
                }
               
            }
             fast.next=null;
        }
        
        
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=head.next;
        removeLoop(head);
        System.out.println("Loop removed if present");
    }

}
    
