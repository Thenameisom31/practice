/* Count the number of possible triangles
Difficulty: MediumAccuracy: 28.53%Submissions: 143K+Points: 4Average Time: 15m
Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.

Examples:

Input: arr[] = [4, 6, 3, 7]
Output: 3
Explanation: There are three triangles possible [3, 4, 6], [4, 6, 7] and [3, 6, 7]. Note that [3, 4, 7] is not a possible triangle.  
Input: arr[] = [10, 21, 22, 100, 101, 200, 300]
Output: 6
Explanation: There can be 6 possible triangles: [10, 21, 22], [21, 100, 101], [22, 100, 101], [10, 100, 101], [100, 101, 200] and [101, 200, 300].
Input: arr[] = [1, 2, 3]
Output: 0
Explanation: No triangles are possible. */

package Two_Pointers_Technique;

import java.util.Arrays;

class CountPossibleTriangles {

    public int countTriangles(int arr[]) {

        Arrays.sort(arr);
        int n = arr.length;
        int res = 0;
        for (int i = 2; i < n; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }

        }
        return res;
    }
    public static void main(String[] args) {
        CountPossibleTriangles cpt = new CountPossibleTriangles();
        int[] arr = {4, 6, 3, 7};
        System.out.println(cpt.countTriangles(arr)); // Output: 3
    }
}