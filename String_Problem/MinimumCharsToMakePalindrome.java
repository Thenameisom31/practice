/* Minimum Characters to Add at Front for Palindrome
Given a string s, the task is to find the minimum number of characters to be added to the front of s to make it palindrome. A palindrome string is a sequence of characters that reads the same forward and backward.

Examples: 

Input: s = "abc"
Output: 2
Explanation: We can make above string palindrome as "cbabc", by adding 'b' and 'c' at front.

Input: str = "aacecaaaa"
Output: 2
Explanation: We can make above string palindrome as "aaaacecaaaa" by adding two a's at front of string. */

public class MinimumCharsToMakePalindrome {

    static int[] computeLPSArray(String pat) {
        int n = pat.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < n) {

            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {

                if (len != 0) {
                    len = lps[len - 1];
                }

                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    static int minChar(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        s = s + "$" + rev;

        int[] lps = computeLPSArray(s);

        return (n - lps[lps.length - 1]);
    }

    public static void main(String[] args) {
        String s = "ab";
        System.out.println(minChar(s));
    }
}
