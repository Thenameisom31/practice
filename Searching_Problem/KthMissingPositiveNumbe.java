package Searching_Problem;

class KthMissingPositiveNumbe {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }

    public static int findKthPositive(int[] arr, int k) {
      /*   int ans = arr.length + k;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > mid + k) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans; */


        int low=0;
        int high=arr.length-1;
        int ans=arr.length+k;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]>mid+k)
            {
                ans=mid+k;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;

    }

}