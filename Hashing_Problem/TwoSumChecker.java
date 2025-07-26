/* Two Sum - Pair with given Sum

comments
Given an array arr[] of n integers and a target value, check if there exists a pair whose sum equals the target. This is a variation of the 2Sum problem.

Examples: 

Input: arr[] = [0, -1, 2, -3, 1], target = -2
Output: true
Explanation: There is a pair (1, -3) with the sum equal to given target, 1 + (-3) = -2.

Input: arr[] = [1, -2, 1, 0, 5], target = 0
Output: false
Explanation: There is no pair with sum equals to given target. */
package Hashing_Problem;
import java.util.HashSet;
public class TwoSumChecker {

    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (seenNumbers.contains(complement)) {
                return true; 
            }
            seenNumbers.add(num);
        }
        return false; 
    }

    public static void main(String[] args) {
        int[] arr1 = {0, -1, 2, -3, 1};
        int target1 = -2;
        System.out.println(hasPairWithSum(arr1, target1)); // Output: true

        int[] arr2 = {1, -2, 1, 0, 5};
        int target2 = 0;
        System.out.println(hasPairWithSum(arr2, target2)); // Output: false
    }
}