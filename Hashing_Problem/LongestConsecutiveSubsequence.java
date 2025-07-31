/* Longest Consecutive Subsequence

comments
Given an array of integers, the task is to find the length of the longest subsequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order. 

Examples:  

Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
Output: 6
Explanation: The consecutive numbers here are from 1 to 6. These 6 numbers form the longest consecutive subsequence [2, 6, 1, 4, 5, 3].

Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
Output: 4
Explanation: The subsequence [1, 3, 4, 2] is the longest subsequence of consecutive elements

Input: arr[] = [36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42]
Output: 5
Explanation: The subsequence [36, 35, 33, 34, 32] is the longest subsequence of consecutive elements */

package Hashing_Problem;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {

    public static int findLongestConsecutiveSubsequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : arr) {
            set.add(num);
        }
        for (int num : arr) {
            if (set.contains(num) && !set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 0;
                while (set.contains(currentNum)) {
                    set.remove(currentNum); // Remove to avoid counting again
                    currentStreak++;
                    currentNum++;
                }
                res = Math.max(res, currentStreak);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 6, 1, 9, 4, 5, 3 };
        System.out.println("Length of Longest Consecutive Subsequence: " + findLongestConsecutiveSubsequence(arr1)); // Output: 6
    }
}