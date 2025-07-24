/* Search element in a sorted matrix

comments
Given a sorted matrix mat[][] of size nxm and an element x, the task is to find if x is present in the matrix or not. Matrix is sorted in a way such that all elements in a row are sorted in increasing order and for row i, where 1 <= i <= n-1, the first element of row i is greater than or equal to the last element of row i-1.

Examples:

Input: x = 14, mat[][] = [[ 1,  5,  9],
                                        [14, 20, 21],
                                        [30, 34, 43]]
Output: true

Input: x = 42, mat[][] = [[ 1,  5,  9,  11],
                                         [14, 20, 21, 26],
                                        [30, 34, 43, 50]]
Output: false */
package Matrix_Problem;

class MatrixBinarySearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n * m - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int row = mid / m;
            int col = mid % m;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 5, 9 },
                { 14, 20, 21 },
                { 30, 34, 43 }
        };
        int target = 0;
        System.out.println(searchMatrix(matrix, target)); // Output: false
    }
}