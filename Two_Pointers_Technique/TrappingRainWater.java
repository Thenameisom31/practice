/* Given an array arr[] of size n consisting of non-negative integers, 
where each element represents the height of a bar in an elevation map and the width of each bar is 1, 
determine the total amount of water that can be trapped between the bars after it rains.
Examples:  

Input: arr[] = [3, 0, 1, 0, 4, 0, 2]
Output: 10
Explanation: The expected rainwater to be trapped is shown in the above image.

Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: We trap 0 + 3 + 1 + 3 + 0 = 7 units.

Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides */

package Two_Pointers_Technique;

public class TrappingRainWater {

    public static int maxWater(int arr[]) {

        int res = 0;
        int left = 1;
        int right = arr.length - 2;

        int rMax = arr[right + 1];
        int lMax = arr[left - 1];

        while (left <= right) {
            if (lMax <= rMax) {
                res += Math.max(0, lMax - arr[left]);
                lMax = Math.max(lMax, arr[left]);
                left++;
            } else {
                res += Math.max(0, rMax - arr[right]);
                rMax = Math.max(rMax, arr[right]);
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(maxWater(arr));
    }
}