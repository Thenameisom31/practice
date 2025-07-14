
/* Aggressive Cows
Given an array stalls[] which denotes the position of a stall and an integer k which denotes the number of aggressive cows. The task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.
Examples: 
Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: We can place cow 1 at position 1, cow 2 at position 4 and cow 3 at position 9. So, the maximum possible minimum distance between two cows is 3.

Input: stalls[] = [6, 7,  9, 11, 13, 15], k = 4
Output: 2
Explanation: We can place cow 1 at position 6, cow 2 at position 9, cow 3 at position 11 and cow 4 at position 15. So, the maximum possible minimum distance between two cows is 2. */

package Searching_Problem;
class AggressiveCows
{
    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int cows = 3;
        System.out.println(maxMinDistance(stalls, cows));
    }

    public static int maxMinDistance(int[] stalls, int cows) {
        int n = stalls.length;
        java.util.Arrays.sort(stalls);
        
        int low = 1; 
        int high = stalls[n - 1] - stalls[0]; 
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlaceCows(stalls, cows, mid)) {
                result = mid; 
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        
        return result;
    }

    private static boolean canPlaceCows(int[] stalls, int cows, int minDist) {
        int count = 1; 
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                count++;
                lastPosition = stalls[i];
                if (count == cows) {
                    return true;
                }
            }
        }
        
        return false; 
    }
}