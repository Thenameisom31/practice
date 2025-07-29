/* Intersection of two Arrays

comments
Given two arrays a[] and b[], find their intersection — the unique elements that appear in both. Ignore duplicates, and the result can be in any order.

Input: a[] = [1, 2, 1, 3, 1], b[] = [3, 1, 3, 4, 1]
Output: [1, 3]
Explanation: 1 and 3 are the only common elements and we need to print only one occurrence of common elements

Input: a[] = [1, 1, 1], b[] = [1, 1, 1, 1, 1]
Output: [1]
Explanation: 1 is the only common element present in both the arrays.

Input: a[] = [1, 2, 3], b[] = [4, 5, 6]
Output: []
Explanation: No common element in both the arrays. */

package Hashing_Problem;
import java.util.ArrayList;
import java.util.HashSet;
public class ArrayCommonValues {

    public static ArrayList<Integer> intersection(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int num : a) {
            set.add(num);
        }
       
        for (int num : b) {
            if (set.contains(num)) {
                ans.add(num);
                set.remove(num); 
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 1, 3, 1};
        int[] b = {3, 1, 3, 4, 1};
        ArrayList<Integer> result = intersection(a, b);
        System.out.println(result); // Output: [1, 3]
    }
}