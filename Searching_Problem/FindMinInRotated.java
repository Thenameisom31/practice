/* Minimum in a Sorted and Rotated Array
Given a sorted array of distinct elements arr[] of size n that is rotated at some unknown point, the task is to find the minimum element in it. 

Examples: 

Input: arr[] = [5, 6, 1, 2, 3, 4]
Output: 1
Explanation: 1 is the minimum element present in the array.

Input: arr[] = [3, 1, 2]
Output: 1
Explanation: 1 is the minimum element present in the array.

Input: arr[] = [4, 2, 3]
Output: 2
Explanation: 2 is the only minimum element in the array */


package Searching_Problem;

public class FindMinInRotated {
    
    public static int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1; 
            } else {
                high = mid;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Minimum element in rotated sorted array: " + findMin(arr));
    }
}
