/* 3 Sum - Count Triplets With Given Sum In Sorted Array

comments
Given a sorted array arr[] and a target value, the task is to find the count of triplets present in the given array having sum equal to the given target. 

More specifically, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

Examples:

Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
Output: 4
Explanation: Two triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2

Input: arr[] = [-2, 0, 1, 1, 5], target = 1
Output: 0
Explanation: There is no triplet whose sum is equal to 1.  */

package Two_Pointers_Technique;

public class TripletSumCounter {

    public static int countTriplets(int[] arr, int target) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else if (sum == target) {
                    int cnt1 = 0;
                    int cnt2 = 0;
                    int ele1 = arr[left];
                    int ele2 = arr[right];
                    while (left <= right && arr[left] == ele1) {
                        cnt1++;
                        left++;
                    }
                    while (left <= right && arr[right] == ele2) {
                        cnt2++;
                        right--;
                    }
                    if (ele1 == ele2) {
                        res += (cnt1 * (cnt1 - 1)) / 2; 
                    } else {
                        res += cnt1 * cnt2; 
                    }
                }
                
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr1 = {-3, -1, -1, 0, 1, 2};
        int target1 = -2;
        System.out.println("Count of triplets: " + countTriplets(arr1, target1)); // Output: 4
    }
}
