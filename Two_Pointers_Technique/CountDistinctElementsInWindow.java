/* ount Distinct Elements In Every Window of Size K

comments
Given an array arr[] of size n and an integer k, return the count of distinct numbers in all windows of size k. 

Examples: 

Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output: [3, 4, 4, 3]
Explanation: First window is [1, 2, 1, 3], count of distinct numbers is 3.
                       Second window is [2, 1, 3, 4] count of distinct numbers is 4.
                       Third window is [1, 3, 4, 2] count of distinct numbers is 4.
                       Fourth window is [3, 4, 2, 3] count of distinct numbers is 3.

Input: arr[] = [4, 1, 1], k = 2
Output: [2, 1]
Explanation: First window is [4, 1], count of distinct numbers is 2.
Second window is [1, 1], count of distinct numbers is 1. */
package Two_Pointers_Technique;
import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElementsInWindow {

    public ArrayList<Integer> countDistinct(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        int n=arr.length;
        for (int i = 0; i < k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);  
        }
        res.add(freq.size());  
        for (int i = k; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1); 
            freq.put(arr[i - k], freq.get(arr[i - k]) - 1);
            if (freq.get(arr[i - k]) == 0) {
                freq.remove(arr[i - k]);  
            }
            res.add(freq.size()); 
        }
        return res;
    }
    public static void main(String[] args) {
        CountDistinctElementsInWindow counter = new CountDistinctElementsInWindow();
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        ArrayList<Integer> result = counter.countDistinct(arr, k);
        System.out.println(result); // Output: [3, 4, 4, 3]
    }
}