

/* Maximum Circular Subarray Sum
Given a circular array arr[] of size n, find the maximum possible sum of a non-empty subarray.

Examples: 

Input: arr[] = {8, -8, 9, -9, 10, -11, 12}
Output: 22
Explanation: Circular Subarray {12, 8, -8, 9, -9, 10} has the maximum sum, which is 22.

Input: arr[] = {10, -3, -4, 7, 6, 5, -4, -1}
Output: 23 
Explanation: Circular Subarray {7, 6, 5, -4, -1, 10} has the maximum sum, which is 23.

Input: arr[] = {-1, 40, -14, 7, 6, 5, -4, -1}
Output: 52
Explanation: Circular Subarray {7, 6, 5, -4, -1, -1, 40} has the maximum sum, which is 52. */

class MaxSumOfCircularArray {
    public static void main(String[] args) {
        int arr[] = { 8, -8, 9, -9, 10, -11, 12 };
        int n = arr.length;
        int maxSum = arr[0];
        int minSum = arr[0];
        int currMaxSum = 0;
        int currMinSum = 0;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {

            currMaxSum = Math.max(currMaxSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currMaxSum);

            // Kadane's to find minimum sum subarray
            currMinSum = Math.min(currMinSum + arr[i], arr[i]);
            minSum = Math.min(minSum, currMinSum);

            totalSum += arr[i];

        }

        int normalSum = maxSum;
        int circularSum = totalSum - minSum;
        if (normalSum == minSum) {

            System.out.println(normalSum);
        } else {
            System.out.println(Math.max(normalSum, circularSum));

        }

    }
}