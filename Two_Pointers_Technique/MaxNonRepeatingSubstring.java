/* 
Longest Substring Without Repeating Characters

comments
Given a string s having lowercase characters, find the length of the longest substring without repeating characters. 

Examples:

Input: s = "geeksforgeeks"
Output: 7 
Explanation: The longest substrings without repeating characters are "eksforg” and "ksforge", with lengths of 7.

Input: s = "aaa"
Output: 1
Explanation: The longest substring without repeating characters is "a"

Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring without repeating characters is "abcdef". */
package Two_Pointers_Technique;

public class MaxNonRepeatingSubstring {
   static public int longestUniqueSubstr(String s) {

        int n = s.length();
        int[] LastIndex = new int[26];
        for (int i = 0; i < 26; i++) {
            LastIndex[i] = -1;
        }
        int start = 0;
        int res = 0;
        for (int end = 0; end < n; end++) {
            start = Math.max(start, LastIndex[s.charAt(end) - 'a'] + 1);
            res = Math.max(res, end - start + 1);
            LastIndex[s.charAt(end) - 'a'] = end;
        }

        return res;
    }
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        int result = longestUniqueSubstr(s);
        System.out.println(result); // Output: 7
    }
}
