/* 
Count Subarrays with given XOR

comments
Given an array of integers arr[] and a number k, the task is to count the number of subarrays having XOR of their elements as k.

Examples: 

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6].

Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. */
package Hashing_Problem;

import java.util.HashMap;

public class SubarrayXorCounter {

    public long subarrayXor(int arr[], int k) {

        int res = 0;
        int prefixXor = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : arr) {
            prefixXor ^= num;
            res += mp.getOrDefault(prefixXor ^ k, 0);
            if (prefixXor == k) {
                res++;
            }
            mp.put(prefixXor, mp.getOrDefault(prefixXor, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        SubarrayXorCounter obj = new SubarrayXorCounter();
        int[] arr1 = { 4, 2, 2, 6, 4 };
        int k1 = 6;
        System.out.println(obj.subarrayXor(arr1, k1)); // Output: 4
    }
}
