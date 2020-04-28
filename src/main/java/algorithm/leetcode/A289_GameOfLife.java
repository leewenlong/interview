package algorithm.leetcode;

import java.util.Arrays;

public class A289_GameOfLife {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        if (row < 1) {
            return;
        }
        int col = board[0].length;
        int[][] first = new int[row][col];
        for (int i = 0; i < row; i++) {
            first[i] = Arrays.copyOf(board[i], col);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int actived = 0;
                for (int m = Math.max(0, i - 1); m <= Math.min(i + 1, row - 1); m++) {
                    for (int n = Math.max(0, j - 1); n <= Math.min(j + 1, col - 1); n++) {
                        if (m == i && n == j) {
                            continue;
                        }
                        if (first[m][n] == 1) {
                            actived++;
                        }
                    }
                }
                switch (actived) {
                    case 0:
                    case 1:
                        board[i][j] = 0;
                        break;
                    case 2:
                        break;
                    case 3:
                        board[i][j] = 1;
                        break;
                    default:
                        board[i][j] = 0;
                        break;
                }
            }
        }
    }
}
