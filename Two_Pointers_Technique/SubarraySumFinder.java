/* 
Subarray with Given Sum

comments
Given a 1-based indexing array arr[] of non-negative integers and an integer sum. You mainly need to return the left and right indexes(1-based indexing) of that subarray. In case of multiple subarrays, return the subarray indexes which come first on moving from left to right. If no such subarray exists return an array consisting of element -1.

Examples: 

Input: arr[] = [15, 2, 4, 8, 9, 5, 10, 23], target = 23
Output: [2, 5]
Explanation: Sum of subarray arr[2...5] is 2 + 4 + 8 + 9 = 23.

Input: arr[] = [1, 10, 4, 0, 3, 5], target = 7
Output: [3, 5]
Explanation: Sum of subarray arr[3...5] is 4 + 0 + 3 = 7.

Input: arr[] = [1, 4], target = 0
Output: [-1]
Explanation: There is no subarray with 0 sum. */

package Two_Pointers_Technique;

import java.util.ArrayList;

public class SubarraySumFinder {

    public ArrayList<Integer> findSubarrayWithSum(int[] arr, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        int currentSum = 0;
        int e = 0;
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum <= target) {
                e = i;
            }
            while (currentSum > target && s <= e) {
                currentSum -= arr[s];
                s++;
            }
            if (currentSum == target) {
                {
                    res.add(s + 1);
                    res.add(e + 1);
                    return res;
                }

            }

        }
        res.add(-1);
        return res;
    }
    public static void main(String[] args) {
        SubarraySumFinder finder = new SubarraySumFinder();
        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        int target = 23;
        ArrayList<Integer> result = finder.findSubarrayWithSum(arr, target);
        System.out.println(result); // Output: [2, 5]
    }

}
