package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int[] first = matrix[0];
        for (int i : first) {
            list.add(i);
        }
        int len = matrix.length - 1;
        while (len > 0) {
            int[][] remain = rotateRemainMatrix(matrix);
            matrix = remain;
            if (remain.length > 0) {
                for (int i1 : remain[0]) {
                    list.add(i1);
                }
                len = remain.length - 1;
            }
        }
        return list;
    }

    private int[][] rotateRemainMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[n][m - 1];

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[n - 1 - j][i - 1] = matrix[i][j];
            }
        }
        return temp;
    }
}
