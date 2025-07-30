/* Union of Two Arrays

comments
Given two arrays a[] and b[], Return union of both the arrays in any order.
Note: Union of two arrays is an array having all distinct elements that are present in either array.

Examples:

Input : a[] = [1, 2, 3, 2, 1], b[] = [3, 2, 2, 3, 3, 2]
Output : [3, 2, 1]
Explanation: 3, 2 and 1 are the distinct elements present in either array.

Input : a[] = [1, 2, 3], b[] = [4, 5, 6]
Output : [1, 2, 3, 4, 5, 6]
Explanation: 1, 2, 3, 4, 5 and 6 are the elements present in either array. */
package Hashing_Problem;
import java.util.ArrayList;
import java.util.HashSet;
class UnionOfArrays {

    public static ArrayList<Integer> union(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int num : a) {
            set.add(num);
        }
        
        for (int num : b) {
            set.add(num);
        }
        
        ans.addAll(set);
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {3, 2, 2, 3, 3, 2};
        ArrayList<Integer> result = union(a, b);
        System.out.println(result); 
    }
}