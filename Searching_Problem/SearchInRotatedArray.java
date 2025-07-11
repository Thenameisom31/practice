
/* Search in a Sorted and Rotated Array
Given a sorted and rotated array arr[] of n distinct elements, the task is to find the index of given key in the array. If the key is not present in the array, return -1.

Examples:  

Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
Output: 8
Explanation: 3 is present at index 8 in arr[].

Input: arr[] = [3, 5, 1, 2], key = 6
Output: -1
Explanation: 6 is not present in arr[].

Input: arr[] = [33, 42, 72, 99], key = 42
Output: 1
Explanation: 42 is found at index 1. */

package Searching_Problem;
class SearchInRotatedArray
{
    public static int search(int[] nums, int key) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == key) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= key && key < nums[mid]) {
                    high = mid - 1; 
                } else {
                    low = mid + 1; 
                }
            } else { 
                if (nums[mid] < key && key <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1; 
                }
            }
        }

        return -1; 
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int key = 0;
        int result = search(nums, key);
        if (result != -1) {
            System.out.println("Element " +nums[result]+" found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}