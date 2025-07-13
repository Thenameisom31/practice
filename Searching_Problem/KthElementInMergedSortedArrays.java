
/* K-th Element of Merged Two Sorted Arrays
Given two sorted arrays of sizes m and n respectively, the task is to find the element that would be at the k-th position in the final sorted array formed by merging these two arrays.

Examples: 

Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final sorted array is [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element is 6.

Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
Output: 256
Explanation: The final sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element is 256. */ 

package Searching_Problem;

public class KthElementInMergedSortedArrays {

    public int kthElement(int a[], int b[], int k) {

        int n = a.length;
        int m = b.length;
        int i = 0, j = 0, last = 0;
        for (int d = 0; d < k; d++) {
            if (i < n) {
                if (j < m && b[j] < a[i]) {
                    last = b[j];
                    j++;
                } else {
                    last = a[i];
                    i++;

                }
            } else if (j < m) {
                last = b[j];
                j++;
            }
        }

        return last;

    }

    public static void main(String[] args) {

        int a[] = { 2, 3, 6, 7, 9 };
        int b[] = { 1, 4, 8, 10 };
        int k = 5;
        KthElementInMergedSortedArrays obj = new KthElementInMergedSortedArrays();
        int result = obj.kthElement(a, b, k);
        System.out.println("The " + k + "th element in the merged sorted arrays is: " + result);
    }

}
