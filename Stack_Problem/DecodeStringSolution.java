/* Decode String

comments
Given an encoded string s, decode it by expanding the pattern k[substring], where the substring inside brackets is written k times. Return the final decoded string.

Examples:  

Input: s = "3[b2[ca]]"
Output: bcacabcacabcaca
Explanation: 
Inner substring "2[ca]" breakdown into "caca".
Now , new string becomes "3[bcaca]"
Similarly "3[bcaca]" becomes "bcacabcacabcaca" which is final result.

Input: s = "3[ab]"
Output: ababab
Explanation: The substring "ab" is repeated 3 times, giving "ababab". */
package Stack_Problem;

import java.util.Stack;

public class DecodeStringSolution {

    static String decodeString(String s) {
       
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ']') {
                st.push(ch);
            } else {
                StringBuilder temp = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    temp.append(st.pop());
                }
                temp.reverse();
                st.pop();
                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.insert(0, st.pop());
                }
                int number = Integer.parseInt(num.toString());

                String repeated = temp.toString().repeat(number);
                for (char c : repeated.toCharArray()) {
                    st.push(c);
                }

            }
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        res.reverse();
        return res.toString();
    }
    public static void main(String[] args) {
        String s = "3[b2[ca]]";
        System.out.println(decodeString(s));
    }
}
