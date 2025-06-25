/* First non-repeating character of given string
Given a string s of lowercase English letters, the task is to find the first non-repeating character. If there is no such character, return '$'.

Examples: 

Input: s = "geeksforgeeks"
Output: 'f'
Explanation: 'f' is the first character in the string which does not repeat.

Input: s = "racecar"
Output: 'e'
Explanation: 'e' is the only character in the string which does not repeat.

Input: "aabbccc"
Output: '$'
Explanation: All the characters in the given string are repeating. */


import java.util.Arrays;
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int vis[] = new int[26];
        Arrays.fill(vis, -1);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int idx = ch - 'a';
            if (vis[idx] == -1) {
                vis[idx] = i;
            } else {
                vis[idx] = -2;
            }
        }
        int idx = -1;
        for (int i = 0; i < 26; i++) {
            if (vis[i] >= 0 && (idx == -1 || vis[i] < idx)) {
                idx = i; 
            }
        }
        if (idx == -1) {
            System.out.println("$");
        } else {
            System.out.println(str.charAt(vis[idx]));
        }
    }
}