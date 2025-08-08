/* 2 Sum - Count Pairs with given Sum in Sorted Array

comments
Given a sorted array arr[] and an integer target, the task is to find the number of pairs in the array whose sum is equal to target.

Examples: 

Input: arr[] = [-1, 1, 5, 5, 7], target = 6
Output: 3
Explanation: Pairs with sum 6 are (1, 5), (1, 5) and (-1, 7).         

Input: arr[] = [1, 1, 1, 1], target = 2
Output: 6
Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1) and (1, 1).

Input: arr[] = [-1, 10, 10, 12, 15], target = 125
Output:  0 */
package Two_Pointers_Technique;
public class CountPairsWithSum {

    int countPairs(int arr[], int target) {
       
        int n=arr.length;
        int left=0;
        int right=n-1;
        int res=0;
        while(left<right)
        {
           
            if(arr[left]+arr[right]<target)
            {
                left++;
            }
            else if(arr[left]+arr[right]>target)
            {
                right--;
            }
            else
            {
                int cnt1=0;
                int cnt2=0;
                int ele1=arr[left];
                int ele2=arr[right];
                while(left<=right&&ele1==arr[left])
                {
                    cnt1++;
                    left++;
                }
                while(left<=right&&ele2==arr[right])
                {
                    cnt2++;
                    right--;
                }
                
                if(ele1==ele2)
                {
                    res+=(cnt1*(cnt1-1))/2;
                }
                else
                {
                    res+=cnt1*cnt2;
                }
            }
            
            
        }
        return res;
    }
    public static void main(String[] args) {
        CountPairsWithSum obj = new CountPairsWithSum();
        int[] arr = {-1, 1, 5, 5, 7};
        int target = 6;
        int result = obj.countPairs(arr, target);
        System.out.println("Number of pairs with sum " + target + ": " + result);
    }
}