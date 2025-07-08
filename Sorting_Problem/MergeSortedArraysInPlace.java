/* Merge Two Sorted Arrays Without Extra Space
Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge both the arrays and rearrange the elements such that the smallest n elements are in a[] and the remaining m elements are in b[]. All elements in a[] and b[] should be in sorted order.

Examples: 

Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
Output: a[] = [2, 2, 3, 4], b[] = [7, 10] 
Explanation: Combined sorted array = [2, 2, 3, 4, 7, 10], array a[] contains smallest 4 elements: 2, 2, 3 and 4, and array b[] contains remaining 2 elements: 7, 10.

Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
Output: a[] = [1, 2, 3, 5, 8, 9], b[] = [10, 13, 15, 20]
Explanation: Combined sorted array = [1, 2, 3, 5, 8, 9, 10, 13, 15, 20], array a[] contains smallest 6 elements: 1, 2, 3, 5, 8 and 9, and array b[] contains remaining 4 elements: 10, 13, 15, 20.

Input: a[] = [0, 1], b[] = [2, 3]
Output: a[] = [0, 1], b[] = [2, 3] 
Explanation: Combined sorted array = [0, 1, 2, 3], array a[] contains smallest 2 elements: 0 and 1, and array b[] contains remaining 2 elements: 2 and 3. */

package Sorting_Problem;

public class MergeSortedArraysInPlace {
    static void mergeArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int gap = (n + m + 1) / 2;

        while (gap > 0) {
            int i = 0, j = gap;

            while (j < n + m) {

                // If both pointers are in the first array a[]
                if (j < n && a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                // If first pointer is in a[] and
                // the second pointer is in b[]
                else if (i < n && j >= n && a[i] > b[j - n]) {
                    int temp = a[i];
                    a[i] = b[j - n];
                    b[j - n] = temp;
                }

                // Both pointers are in the second array b
                else if (i >= n && b[i - n] > b[j - n]) {
                    int temp = b[i - n];
                    b[i - n] = b[j - n];
                    b[j - n] = temp;
                }
                i++;
                j++;
            }

            if (gap == 1) {
                break;
            }

            gap = (gap + 1) / 2;
        }
    }
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};

        mergeArrays(a, b);

        System.out.print("Merged array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        for (int i : b) {
            System.out.print(i + " ");
        }   
    }
}
