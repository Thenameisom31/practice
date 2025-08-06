/* Count Pairs With Sum Less Than Target

comments
Given an array arr[] and an integer target, the task is to find the count of pairs whose sum is strictly less than given target.

Examples:

Input: arr[] = [7, 2, 5, 3], target = 8
Output: 2 
Explanation: There are 2 pairs with sum less than 8: (2, 5) and (2, 3). 

Input: arr[] = [5, 2, 3, 2, 4, 1], target = 5
Output: 4
Explanation: There are 4 pairs whose sum is less than 5: (2, 2), (2, 1), (3, 1) and (2, 1).

Input: arr[] = [2, 1, 8, 3, 4, 7, 6, 5], target = 7
Output: 6
Explanation: There are 6 pairs whose sum is less than 7: (2, 1), (2, 3), (2, 4), (1, 3), (1, 4) and (1, 5). */

package Two_Pointers_Technique;

import java.util.Arrays;

public class PairLessThanTarget {
    int countPairs(int arr[], int target) {

        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int ans = 0;
        Arrays.sort(arr);
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum >= target) {
                right--;
            } else {
                ans += right - left;
                left++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        PairLessThanTarget obj = new PairLessThanTarget();
        int[] arr = {7, 2, 5, 3};
        int target = 8;
        System.out.println("Count of pairs with sum less than " + target + ": " + obj.countPairs(arr, target));
    }
}
