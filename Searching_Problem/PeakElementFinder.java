
/* Peak Element in Array
Given an array arr[] where no two adjacent elements are same, find the index of a peak element. An element is considered to be a peak element if it is strictly greater than its adjacent elements. If there are multiple peak elements, return the index of any one of them.

Note: Consider the element before the first element and the element after the last element to be negative infinity.

Examples:

Input: arr[] = [1, 2, 4, 5, 7, 8, 3]
Output: 5
Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].

Input: arr[] = [10, 20, 15, 2, 23, 90, 80]
Output: 1 or 5
Explanation: arr[1] = 20 and arr[5] = 90 are peak elements because arr[0] < arr[1] > arr[2] and arr[4] < arr[5] > arr[6].

Input: arr[] = [1, 2, 3]
Output: 2
Explanation: arr[2] is a peak element because arr[1] < arr[2] and arr[2] is the last element, so it has negative infinity to its right. */


package Searching_Problem;

class PeakElementFinder {
    public static int findPeakElement(int arr[]) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        if (arr[0] >= arr[1]) {
            return 0;
        }
        if (arr[n - 1] >= arr[n - 2]) {
            return n - 1;
        }

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 4, 5, 7, 8, 3};
        System.out.println("Peak Element Index: " + findPeakElement(arr1)); // Output: 5

        int arr2[] = {10, 20, 15, 2, 23, 90, 80};
        System.out.println("Peak Element Index: " + findPeakElement(arr2)); // Output: 1 or 5

        int arr3[] = {1, 2, 3};
        System.out.println("Peak Element Index: " + findPeakElement(arr3)); // Output: 2
    }
   
}