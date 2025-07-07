
/* Non-Overlapping Intervals
Given a list of intervals with starting and ending values, the task is to find the minimum number of intervals that are required to be removed to make remaining intervals non-overlapping.

Examples:

Input: intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]
Output: 1
Explanation: Removal of [1, 3] makes the ranges non-overlapping.

Input: intervals[][] = [[1, 3], [1, 3], [1, 3]]
Output: 2
Explanation: Removal of two occurrences of [1, 3] makes the remaining ranges non-overlapping.

Input: intervals[][] = [[1, 2], [5, 10], [18, 35], [40, 45]]
Output: 0
Explanation: All ranges are already non-overlapping. */

package Sorting_Problem;

import java.util.Arrays;

public class NonOverlappingIntervals {

    static int minRemoval(int intervals[][]) {

        int count = 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;

            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {5, 10}, {18, 35}, {40, 45}};
        int result = minRemoval(intervals);
        System.out.println("Minimum number of intervals to remove: " + result);
    }
}