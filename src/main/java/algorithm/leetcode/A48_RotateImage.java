package algorithm.leetcode;

public class A48_RotateImage {

    /**
     * [1,2,3],        [7,4,1],
     * [4,5,6],  --->  [8,5,2],
     * [7,8,9]         [9,6,3]
     * <p>
     * first:以正角45度镜像
     * [1,2,3],        [9,6,3],
     * [4,5,6],  --->  [8,5,2],
     * [7,8,9]         [7,4,1]
     * second:上下镜像
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int row = len - 1;
        int col = len - 1;
        for (int i = 0; i < row; i++, col--) {
            for (int j = 0; j < col; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][len - i - 1];
                matrix[len - 1 - j][len - i - 1] = t;
            }
        }
        for (int i = 0; i < len / 2; i++) {
            int[] t = matrix[i];
            matrix[i] = matrix[len - i - 1];
            matrix[len - i - 1] = t;
        }
    }

    /**
     * [1,2,3],        [7,4,1],
     * [4,5,6],  --->  [8,5,2],
     * [7,8,9]         [9,6,3]
     * <p>
     * first:以正角145度镜像
     * [1,2,3],        [1,4,7],
     * [4,5,6],  --->  [2,5,8],
     * [7,8,9]         [3,6,9]
     * second:左右镜像
     *
     * @param matrix
     */
    public void rotateII(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len ; j++) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
            }
        }
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int t = matrix[j][i];
                matrix[j][i] = matrix[j][len-i-1];
                matrix[j][len-i-1]=t;
            }
        }
    }
}
