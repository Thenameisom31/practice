/* 
Count Inversions of an Array
Given an integer array arr[] of size n, find the inversion count in the array. Two array elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

Note: Inversion Count for an array indicates that how far (or close) the array is from being sorted. If the array is already sorted, then the inversion count is 0, but if the array is sorted in reverse order, the inversion count is maximum. 

Examples: 

Input: arr[] = {4, 3, 2, 1}
Output: 6 */


package Sorting_Problem;

class InversionCount
{
    // Function to count inversions in the array
    public static int countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    // Helper function to perform merge sort and count inversions
    private static int mergeSortAndCount(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int count = 0;

        count += mergeSortAndCount(arr, left, mid);
        count += mergeSortAndCount(arr, mid + 1, right);
        count += mergeAndCount(arr, left, mid, right);

        return count;
    }

    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        int inversions = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
                inversions += (mid + 1) - (left + i); 
            }
        }

        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }

        return inversions;
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int inversionCount = countInversions(arr);
        System.out.println("Number of inversions are: " + inversionCount);
    }
}