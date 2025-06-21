
/* Find Smallest Missing Positive Number
Given an unsorted array arr[] with both positive and negative elements, the task is to find the smallest positive number missing from the array.

Note: You can modify the original array.

Examples:

Input: arr[] = {2, -3, 4, 1, 1, 7}
Output: 3
Explanation: 3 is the smallest positive number missing from the array.

Input: arr[] = {5, 3, 2, 5, 1}
Output: 4
Explanation: 4 is the smallest positive number missing from the array.

Input: arr[] = {-8, 0, -1, -4, -3}
Output: 1
Explanation: 1 is the smallest positive number missing from the array. */

import java.util.Arrays;

class FirstMissingInt {
    public static void main(String[] args) {
        int[] arr = { 2, -3, 4, 1, 1, 7 };
        FirstMissingInt fmi = new FirstMissingInt();
        /*
         * time complexity: O(n log n)
         * space complexity: O(1)
         * Arrays.sort(arr);
         * int missingInt = 1;
         * int low = 0;
         * int high = arr.length - 1;
         * while(low <= high) {
         * int mid = low + (high - low) / 2;
         * if (arr[mid] < missingInt) {
         * low = mid + 1;
         * } else if (arr[mid] > missingInt) {
         * high = mid - 1;
         * } else {
         * missingInt++;
         * low = mid + 1;
         * }
         * }
         * System.out.println("The first missing positive integer is: " + missingInt);
         */
        System.out.println("First missing positive integer is : " + fmi.missingNumber(arr));
    }

    // time complexity: O(n)
    // space complexity: O(1)
    int missingNumber(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (arr[i] >= 1 && arr[i] <= n &&
                    arr[i] != arr[arr[i] - 1]) {

                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}