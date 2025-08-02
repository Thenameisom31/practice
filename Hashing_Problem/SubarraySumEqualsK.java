/* Count Subarrays having Sum K

comments
Given an array arr[] of postive and negative integers, the objective is to find the number of subarrays having a sum exactly equal to a given number k.

Examples: 

Input : arr[] = [10, 2, -2, -20, 10], k = -10
Output : 3
Explanation: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum equal to -10.

Input : arr[] = [9, 4, 20, 3, 10, 5], k = 33
Output : 2
Explanation: Subarrays: arr[0...2], arr[2...4] have sum equal to 33.

Input : arr[] = [1, 3, 5], k = 2
Output : 0
Explanation: No subarrays with 0 sum. */
package Hashing_Problem;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public int cntSubarrays(int[] arr, int k) {

        int res = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum == k) {
                res++;
            }
            if (prefixSum.containsKey(currSum - k)) {
                res += prefixSum.get(currSum - k);
            }
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        int[] arr1 = { 10, 2, -2, -20, 10 };
        int k1 = -10;
        System.out.println(obj.cntSubarrays(arr1, k1)); // Output: 3
    }
}