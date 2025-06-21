package practice;
/* Maximum Product Subarray
Given an integer array, the task is to find the maximum product of any subarray.

Examples:

Input: arr[] = {-2, 6, -3, -10, 0, 2}
Output: 180
Explanation: The subarray with maximum product is {6, -3, -10} with product = 6 * (-3) * (-10) = 180

Input: arr[] = {-1, -3, -10, 0, 60}
Output: 60
Explanation: The subarray with maximum product is {60}. */

public class MaximumProductOfA {
    
    public static void main(String[] args)
    {
        int arr[] = {-2, 6, -3, -10, 0, 2};
        int maxProduct=arr[0];
        int currMin=arr[0];
        int curraxM=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            int temp = Math.max(arr[i], Math.max(arr[i] * curraxM, arr[i] * currMin));
            currMin = Math.min(arr[i], Math.min(arr[i] * curraxM, arr[i] * currMin));

            curraxM = temp;
            maxProduct = Math.max(maxProduct, curraxM);
            
        }
        System.out.println("Maximum product of a subarray is: " + maxProduct );
    }

    
}
