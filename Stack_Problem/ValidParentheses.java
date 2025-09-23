/* 
Parenthesis Checker
Difficulty: EasyAccuracy: 28.56%Submissions: 695K+Points: 2
Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']'. Determine whether the Expression is balanced or not.
An expression is balanced if:

Each opening bracket has a corresponding closing bracket of the same type.
Opening brackets must be closed in the correct order.
Examples :

Input: s = "[{()}]"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "[()()]{}"
Output: true
Explanation: All the brackets are well-formed. */
package Stack_Problem;

public class ValidParentheses {

    static public boolean isBalanced(String s) {

        int top = -1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = arr[i];
            if (c == '(' || c == '{' || c == '[') {
                arr[++top] = c;
            } else if (c == ')' || c == '}' || c == ']') {
                if (top == -1) {
                    return false;
                }
                if ((c == ')' && arr[top] != '(') ||
                        (c == '}' && arr[top] != '{') ||
                        (c == ']' && arr[top] != '[')) {
                    return false;
                }
                top--;
            }

        }
        return top == -1;
    }

    public static void main(String[] args) {

        String s = "[{()}]";
        System.out.println(isBalanced(s));
    }

}
