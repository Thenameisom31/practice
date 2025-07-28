/* 
3 Sum - Find All Triplets with Zero Sum

comments
Given an array arr[], the task is to find all possible indices {i, j, k} of triplet {arr[i], arr[j], arr[k]} such that their sum is equal to zero and all indices in a triplet should be distinct (i != j, j != k, k != i). We need to return indices of a triplet in sorted order, i.e., i < j < k.

Examples :

Input: arr[] = {0, -1, 2, -3, 1}
Output: {{0, 1, 4}, {2, 3, 4}}
Explanation:  Two triplets with sum 0 are:
arr[0] + arr[1] + arr[4] = 0 + (-1) + 1 = 0
arr[2] + arr[3] + arr[4] = 2 + (-3) + 1 = 0

Input: arr[] = {1, -2, 1, 0, 5}
Output: {{0, 1, 2}}
Explanation: Only triplet which satisfies the condition is arr[0] + arr[1] + arr[2] = 1 + (-2) + 1 = 0

Input: arr[] = {2, 3, 1, 0, 5}
Output: {{}}
Explanation: There is no triplet with sum 0 */

package Hashing_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ZeroSumTripletsFinder {

    // User function Template for Java

    
    public static List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                int val = -1 * (arr[j] + arr[k]);
                if (map.containsKey(val)) {
                    for (int i : map.get(val)) {
                        ans.add(Arrays.asList(i, j, k));
                    }
                }
            }
            map.putIfAbsent(arr[j], new ArrayList<>());
            map.get(arr[j]).add(j);
        }
        return ans;
    }
    

    // public static List<List<Integer>> findTriplets(int[] arr) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     int n = arr.length;

    //     for (int i = 0; i < n - 2; i++) {
    //         for (int j = i + 1; j < n - 1; j++) {
    //             for (int k = j + 1; k < n; k++) {
    //                 if (arr[i] + arr[j] + arr[k] == 0) {
    //                     ans.add(Arrays.asList(i, j, k));
    //                 }
    //             }
    //         }
    //     }
    //     return ans;
    // }



    public static void main(String[] args) {

        int[] arr = { -0, -1, 2, -3, 1};
        List<List<Integer>> res = findTriplets(arr);
        for (List<Integer> triplet : res) {
            System.out.println(triplet.get(0) + " " + triplet.get(1) + " " + triplet.get(2));
        }

        // 0 1 4
        // 2 3 4



    }
}
