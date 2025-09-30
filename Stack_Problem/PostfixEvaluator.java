/* 
Postfix Evaluation
Difficulty: MediumAccuracy: 63.04%Submissions: 128K+Points: 4
You are given an array of strings arr[] that represents a valid arithmetic expression written in Reverse Polish Notation (Postfix Notation). Your task is to evaluate the expression and return an integer representing its value.

Note: A postfix expression is of the form operand1 operand2 operator (e.g., "a b +"). 
And the division operation between two integers always computes the floor value, i.e floor(5 / 3) = 1 and floor(-5 / 3) = -2.
It is guaranteed that the result of the expression and all intermediate calculations will fit in a 32-bit signed integer.

Examples:

Input: arr[] = ["2", "3", "1", "*", "+", "9", "-"]
Output: -4
Explanation: If the expression is converted into an infix expression, it will be 2 + (3 * 1) – 9 = 5 – 9 = -4. */
package Stack_Problem;

import java.util.Stack;

public class PostfixEvaluator {

    static int floorDiv(int a, int b) {
        if (a * b < 0 && a % b != 0) {
            return (a / b) - 1;
        }
        return a / b;
    }

    public int evaluatePostfix(String[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        for (String token : arr) {
            if (Character.isDigit(token.charAt(0)) || token.length() > 1 && token.charAt(0) == '-') {
                st.push(Integer.parseInt(token));
            } else {
                int val1 = st.pop();
                int val2 = st.pop();
                if (token.equals("+")) {
                    st.push(val2 + val1);
                } else if (token.equals("-")) {
                    st.push(val2 - val1);
                } else if (token.equals("*")) {
                    st.push(val1 * val2);
                } else if (token.equals("/")) {
                    st.push(floorDiv(val2, val1));
                } else if (token.equals("^")) {
                    st.push((int) Math.pow(val2, val1));
                }
            }
        }
        return st.pop();

    }
    public static void main(String[] args) {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        String[] arr = {"2", "3", "1", "*", "+", "9", "-"};
        int result = evaluator.evaluatePostfix(arr);
        System.out.println("The result of the postfix expression is: " + result); // Output: -4
    }
}
