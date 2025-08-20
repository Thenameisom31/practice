/* Longest Subarray With Equal Number of 0s and 1s

comments
Given an array arr[] containing only 0s and 1s, find the longest subarray which contains equal no of 0s and 1s.

Examples: 

Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
Output: 6
Explanation: arr[1 ... 6] is the longest subarray with three 0s and three 1s.

Input: arr[] = [0, 0, 1, 1, 0]
Output: 4
Explanation: arr[0 ... 3] or  arr[1 ... 4] is the longest subarray with two 0s and two 1s.

Input: arr[] = [0]
Output: 0
Explanation: There is no subarray with an equal number of 0s and 1s */
package prefixSum_Problem;

import java.util.HashMap;

public class LongestEqualZeroOneSubarray {

    int findLongestSubarray(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int prefSum = 0;
        for (int i = 0; i < arr.length; i++) {

            prefSum += (arr[i] == 0) ? -1 : 1;
            if (prefSum == 0) {

                res = i + 1;
            }
            if (map.containsKey(prefSum)) {
                res = Math.max(res, i - map.get(prefSum));
            } else {
                map.put(prefSum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestEqualZeroOneSubarray obj = new LongestEqualZeroOneSubarray();
        int arr[] = { 1, 0, 1, 1, 1, 0, 0 };
        int result = obj.findLongestSubarray(arr);
        System.out.println("Length of the longest subarray with equal number of 0s and 1s is: " + result); //output should be 6
        int arr2[] = { 0, 0, 1, 1, 0 };
        int result2 = obj.findLongestSubarray(arr2);
        System.out.println("Length of the longest subarray with equal number of 0s and 1s is: " + result2);//output should be 4
        int arr3[] = { 0 };
        int result3 = obj.findLongestSubarray(arr3);
        System.out.println("Length of the longest subarray with equal number of 0s and 1s is: " + result3);//output should be 0
    }
}