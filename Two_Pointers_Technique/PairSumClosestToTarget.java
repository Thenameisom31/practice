/* 2 Sum - Pair Sum Closest to Target

comments
Given an array arr[] of n integers and an integer target, the task is to find a pair in arr[] such that it’s sum is closest to target.

Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

Examples:

Input: arr[] = [10, 30, 20, 5], target = 25
Output: [5, 20]
Explanation: Out of all the pairs, [5, 20] has sum = 25 which is closest to 25.

Input: arr[] = [5, 2, 7, 1, 4], target = 10
Output: [2, 7]
Explanation: As (4, 7) and (2, 7) both are closest to 10, but absolute difference of (2, 7) is 5 and (4, 7) is 3. Hence,[2, 7] has maximum absolute difference and closest to target.

Input: arr[] = [10], target = 10
Output: []
Explanation: As the input array has only 1 element, return an empty array. */

package Two_Pointers_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSumClosestToTarget {

    public List<Integer> findClosestPair(int[] arr, int target) {
        int n = arr.length;
        if (n < 2)
            return new ArrayList<>();

        Arrays.sort(arr);
        int left = 0, right = n - 1;
        int minDiff = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        while (left < right) {
            int currSum = arr[left] + arr[right];
            if (Math.abs(target - currSum) < minDiff) {
                minDiff = Math.abs(target - currSum);
                res = Arrays.asList(arr[left], arr[right]);
            }
            if (currSum < target) {
                left++;
            } else if (currSum > target) {
                right--;
            } else {
                return res;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        
        PairSumClosestToTarget obj = new PairSumClosestToTarget();
        int[] arr = {10, 30, 20, 5};
        int target = 19;
        List<Integer> result = obj.findClosestPair(arr, target);
        if (result.isEmpty()) {
            System.out.println("No valid pair found.");
        } else {
            System.out.println("Pair with sum closest to target: " + result);
        }
    }
}