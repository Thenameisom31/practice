/* Search in row wise sorted matrix

comments
Given a row-wise sorted matrix mat[][] and an integer x, the task is to check if x is present in mat[][] or not. Note that there is no ordering among column elements.

Examples:

Input: x = 9, mat[][] = [[3, 4, 9],
[2, 5, 6],
[9, 25, 27]]
Output: true
Explanation: mat[0][2] is equal to 9.

Input: x = 56, mat[][] = [[19, 22, 27, 38, 55, 67]]
Output: false
Explanation: 56 is not present in mat[][]. */

package Matrix_Problem;

public class SearchInRowWiseSortedMatrix {

    public static boolean search(int[][] mat, int x) {

        for (int i = 0; i < mat.length; i++) {
            int low = 0;
            int high = mat[0].length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (mat[i][mid] == x) {
                    return true;
                } else if (mat[i][mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 3, 4, 9 },
                { 2, 5, 6 },
                { 9, 25, 27 }
        };
        int x = 3;
        System.out.println(search(mat, x)); // Output: true
    }
}