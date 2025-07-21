/* 
O

Search...
























Rotate Square Matrix by 90 Degrees Counterclockwise

comments
Given a square matrix mat[][], rotate it by 90 degrees in counterclockwise direction without using any extra space.

Examples: 

Input: mat[][] = [[1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]]
Output: [[3, 6, 9], 
                [2, 5, 8], 
                [1, 4, 7]]

Explanation: Each element is moved to its new position based on a 90-degree counter clockwise rotation.

Input: mat[][] = [[1, 2,  3, 4],
            [5, 6, 7,  8], 
              [9, 10, 11, 12],
              [13, 14, 15, 16]]
Output: [[4, 8, 12, 16], 
              [3, 7, 11, 15],
              [2, 6, 10, 14],
              [1, 5, 9, 13]]

Explanation: Each element is moved to its new position based on a 90-degree counter clockwise rotation. */
package Matrix_Problem;

public class RowColumnMatrixSearch {

    public static boolean findElement(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (x > mat[i][j]) {
                i++;
            } else if (x < mat[i][j]) {
                j--;
            } else {
                return true; // Element found
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };
        int x = 32;
        boolean found = findElement(mat, x);
        if (found) {
            System.out.println("Element " + x + " found in the matrix.");
        } else {
            System.out.println("Element " + x + " not found in the matrix.");
        }
    }
}