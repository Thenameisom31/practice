/* 
Allocate Minimum Pages
Given an array arr[] and an integer k, where arr[i] denotes the number of pages of a book and k denotes total number of students. All the books need to be allocated to k students in contiguous manner, with each student getting at least one book.

The task is to minimize the maximum number of pages allocated to a student. If it is not possible to allocate books to all students, return -1.

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Books can be distributed in following ways:

[12] and [34, 67, 90] - The maximum pages assigned to a student is 34 + 67 + 90 = 191.
[12, 34] and [67, 90] - The maximum pages assigned to a student is 67 + 90 = 157.
[12, 34, 67] and [90] - The maximum pages assigned to a student is 12 + 34 + 67 = 113.
The third combination has the minimum pages assigned to a student which is 113.

Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.

Input: arr[] = [22, 23, 67], k = 1
Output: 112
Explanation: Since there is only 1 student, all books are assigned to that student. So, maximum pages assigned to a student is 22 + 23 + 67 = 112. */


package Searching_Problem;

import java.util.Arrays;

public class AllocateMinimumPages {

    public static boolean check(int[] arr, int k, int pageLimit) {
        int count = 1;
        int pageSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pageSum + arr[i] > pageLimit) {
                count++;
                pageSum = arr[i];
            } else {
                pageSum = pageSum + arr[i];
            }
        }

        return (count <= k);
    }

    public static int findPages(int[] arr, int k) {
        // code here
        if (k > arr.length) {
            return -1;
        }
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(arr, k, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(findPages(arr, k)); // Output: 113
    }

}
