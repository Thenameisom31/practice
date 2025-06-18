public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = { -2, -4 };
        int res=arr[0];
        int maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            res = Math.max(res, maxEndingHere);
        }

        System.out.println("Maximum contiguous sum is " + res);
        
    }
}
