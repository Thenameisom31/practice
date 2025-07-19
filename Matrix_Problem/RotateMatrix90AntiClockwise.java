
/* Rotate Square Matrix by 90 Degrees Counterclockwise

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

class RotateMatrix90AntiClockwise {
    public static void rotate(int[][] mat) {
        int n = mat.length;

        // Reverse each row
        for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;
            while (start < end) {
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

    }
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        rotate(mat);

        // Print the rotated matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}