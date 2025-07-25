
/* Set Matrix Rows and Columns to Zeroes

comments
Given a matrix mat[][] of size nxm, the task is to update the matrix such that if an element is zero, set its entire row and column to zeroes.

Examples:

Input: mat[][] = [[1, -1, 1],
                            [-1, 0, 1],
                            [1, -1, 1]]
Output: [[1, 0, 1],
               [0, 0, 0],
               [1, 0, 1]]
Explanation: mat[1][1] = 0, so all elements in row 1 and column 1 are updated to zeroes.

Input: mat[][] = [[0, 1, 2, 0],
                            [3, 4, 0, 2],
                           [1, 3, 1, 5]]
Output: [[0, 0, 0, 0],
                [0, 0, 0, 0],
                [0, 3, 0, 0]]
Explanation: mat[0][0], mat[1][2] and mat[0][3] are 0s, so all elements in row 0, row 1, column 0, column 2 and column 3 are updated to zeroes. */

package Matrix_Problem;

public class MatrixZeroSetter {

    public void setMatrixZeroes(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int c0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    if (j == 0) {
                        c0 = 0;
                    } else {
                        mat[0][j] = 0;
                    }

                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        if (mat[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }

        if (c0 == 0) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }

    }
    public static void main(String[] args) {
        MatrixZeroSetter setter = new MatrixZeroSetter();
        int[][] mat = {
                { 1, -1, 1 },
                { -1, 0, 1 },
                { 1, -1, 1 }
        };
        setter.setMatrixZeroes(mat);
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
