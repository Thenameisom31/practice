/* Stack with Minimum

comments
Design a SpecialStack that supports push(x), pop(), peek(), and getMin() in O(1) time.

push(x) → add element x
pop() → remove top element
peek() → return top element without removing; -1 if empty
getMin() → return minimum element; -1 if empty
All operations run in O(1).

 Example: 

Input: operations[] = [push(2), push(3), peek(), pop(), getMin(), push(1), getMin()]
Output: [3, 2, 1] 
Explanation: 
push(2): Stack is [2]
push(3): Stack is [2, 3]
peek(): Top element is 3
pop(): Removes 3, stack is [2]
getMin(): Minimum element is 2
push(1): Stack is [2, 1]
getMin(): Minimum element is 1

Input: operations[] = [push(10), getMin(), push(5), getMin(), pop()]
Output: [10, 5]
Explanation: 
push(10): Stack is [10]
getMin(): Minimum element is 10
push(5): Stack is [10, 5]
getMin(): Minimum element is 5
pop(): Removes 5, stack is [10 */
package Stack_Problem;

import java.util.Stack;

public class StackWithMin {

    Stack<Integer> minstack;
    Stack<Integer> st;
    public StackWithMin() {
       
        minstack=new Stack<>();
        st=new Stack<>();
        
    }

    public void push(int x) {
        
        st.push(x);
        if(minstack.isEmpty()||x<=minstack.peek())
        {
            minstack.push(x);
        }
    }

    public void pop() {
        
        if(st.isEmpty())return ;
        
        int removed=st.pop();
        if(!minstack.isEmpty()&& removed==minstack.peek())
        {
            minstack.pop();
        }
    }

    public int peek() {
       
        return st.isEmpty()?-1:st.peek();
    }

    boolean isEmpty() {
       
        return st.isEmpty();
    }

    public int getMin() {
       
        return minstack.isEmpty()?-1:minstack.peek();
    }
    public static void main(String[] args) {
        
        StackWithMin s=new StackWithMin();
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.getMin());
        s.push(1);
        System.out.println(s.getMin());
    }
}