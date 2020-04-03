package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A51_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<char[][]> list = new ArrayList<>();
        char[][] temp = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = '.';
            }
        }
        solveNQueens(list, temp, 0, n);
        for (char[][] matrix : list) {
            List<String> r = new ArrayList<>();
            for (char[] rows : matrix) {
                r.add(new String(rows));
            }
            res.add(r);
        }
        return res;
    }

    private void solveNQueens(List<char[][]> list, char[][] temp, int row, int n) {
        if (row == n) {
            char[][] chars = new char[n][n];
            for (int k = 0; k < n; k++) {
                chars[k] = Arrays.copyOf(temp[k], n);
            }
            list.add(chars);
        } else {
            for (int col = 0; col < n; col++) {
                if (!isValid(temp, row, col, n)) {
                    continue;
                }
                temp[row][col] = 'Q';
                solveNQueens(list, temp, row + 1, n);
                temp[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] temp, int i, int j, int n) {

        for (int k = 0; k < n; k++) {
            if (temp[i][k] == 'Q' && k != j) {
                return false;
            }
            if (temp[k][j] == 'Q' && k != i) {
                return false;
            }
        }
        int r = i;
        int c = j;
        while (r > 0 && c > 0) {
            if (temp[r - 1][c - 1] == 'Q') {
                return false;
            }
            r--;
            c--;
        }
        while (i > 0 && j < n - 1) {
            if (temp[i - 1][j + 1] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
