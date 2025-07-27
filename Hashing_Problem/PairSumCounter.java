/* 2 Sum - Count pairs with given sum

comments
Given an array arr[] of n integers and a target value, the task is to find the number of pairs of integers in the array whose sum is equal to target.

Examples:  

Input: arr[] = {1, 5, 7, -1, 5}, target = 6
Output:  3
Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5).         

Input: arr[] = {1, 1, 1, 1}, target = 2
Output:  6
Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1) and (1, 1).

Input: arr[] = {10, 12, 10, 15, -1}, target = 125
Output:  0 */

package Hashing_Problem;

import java.util.HashMap;

public class PairSumCounter {

    public int countPairsWithSum(int[] arr, int target) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = target - num;
            if (numCount.containsKey(complement)) {
                count += numCount.get(complement);
            }
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        PairSumCounter counter = new PairSumCounter();

        int[] arr1 = { 1, 5, 7, -1, 5 };
        int target1 = 6;
        System.out.println(counter.countPairsWithSum(arr1, target1)); // Output: 3

    }

}