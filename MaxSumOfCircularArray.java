package practice;

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
            
           /*  currMaxSum = Math.max(currMaxSum + arr[i], arr[i]);
            maxSum = Math.max(currMaxSum, maxSum);

            currMinSum = Math.min(currMinSum - arr[i], arr[i]);
            minSum = Math.min(currMinSum, minSum);

            totalSum += arr[i]; */


            currMaxSum = Math.max(currMaxSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currMaxSum); 
          
            // Kadane's to find minimum sum subarray
            currMinSum = Math.min(currMinSum + arr[i], arr[i]);
            minSum = Math.min(minSum, currMinSum);

            totalSum += arr[i];


            

        }
        /* int normalMaxSum = maxSum;
        int circularMaxSum = totalSum - minSum;
        System.out.println(normalMaxSum);
        System.out.println(circularMaxSum);
        System.out.println(totalSum);
        System.out.println(minSum); */

        int normalSum = maxSum;
        int circularSum = totalSum - minSum;
        if (normalSum==minSum) {

            System.out.println(normalSum);
        } else {
            System.out.println(Math.max(normalSum, circularSum));
            System.out.println(normalSum);
            System.out.println(circularSum);
            System.out.println(totalSum);
            System.out.println(minSum);
            System.out.println(maxSum);   
            
        }

    }
}