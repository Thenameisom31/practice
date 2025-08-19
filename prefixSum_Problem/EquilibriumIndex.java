/* 
Equilibrium Index

comments
Given an array arr[] of size n, the task is to return an equilibrium index (if any) or -1 if no equilibrium index exists. The equilibrium index of an array is an index such that the sum of all elements at lower indexes equals the sum of all elements at higher indexes.

Note: When the index is at the start of the array, the left sum is 0, and when it's at the end, the right sum is 0.

Examples:

Input: arr[] = [1, 2, 0, 3]
Output: 2
Explanation: The sum of left of index 2 is 1 + 2 = 3 and sum on right of index 2 is 3.

Input: arr[] = [1, 1, 1, 1]
Output: -1 
Explanation: There is no equilibrium index in the array.

Input: arr[] = [-7, 1, 5, 2, -4, 3, 0]
Output: 3
Explanation: The sum of left of index 3 is -7 + 1 + 5 = -1 and sum on right of index 3 is -4 + 3 + 0 = -1. */
package prefixSum_Problem;

public class EquilibriumIndex {

    public static int findEquilibrium(int arr[]) {

        int total = 0;
        for (int ele : arr) {
            total += ele;
        }
        int prefSum = 0;
        int suffSum = 0;
        for (int pivot = 0; pivot < arr.length; pivot++) {
            suffSum = total - prefSum - arr[pivot];
            if (prefSum == suffSum) {
                return pivot;
            }
            prefSum += arr[pivot];
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        int index = findEquilibrium(arr);
        if (index != -1) {
            System.out.println("Equilibrium index is: " + index);
        }

    }
}
