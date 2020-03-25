package algorithm.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    private Set<String> validSet = new HashSet<>(9*9*3);
    public boolean solve(int[][] input) {
        if (!validInput(input)) {
            return false;
        }
        return backtrack(input, 0, 0);
    }

    private boolean backtrack(int[][] input, int row, int col) {
        if (col == 9) {//列到头进行下一行
            return backtrack(input, row + 1, 0);
        }
        if (row == 9) {
            return true;
        } else {
            if (input[row][col] != 0) {//已有数字进行下一个
                return backtrack(input, row, col + 1);
            }
            for (int num = 1; num <= 9; num++) {
                if (!valid(num, row, col)) {
                    continue;
                }
                input[row][col] = num;
                boolean b = backtrack(input, row, col + 1);
                if (b) {//结束
                    return true;
                }
                input[row][col] = 0;
                remove(num, row, col);
            }
            return false;//所有数字都不符合，回溯上一个

        }
    }

    //回溯上一个需要删除存储的当前行列块
    private void remove(int num, int row, int col) {
        String r = "r" + row + num;
        String c = "c" + col + num;
        String b = "b" + row / 3 + col / 3 + num;

        validSet.remove(r);
        validSet.remove(c);
        validSet.remove(b);
    }
    /**
     * 每个数字分别存储三次，分别为所在行、列、块
     * 如input[1][2]=2 则为r12、c22、b002
     * @param num
     * @param row
     * @param col
     * @return
     */
    private boolean valid(int num, int row, int col) {
        String r = "r" + row + num;
        String c = "c" + col + num;
        String b = "b" + row / 3 + col / 3 + num;
        if (validSet.contains(r) || validSet.contains(c) || validSet.contains(b)) {
            return false;
        }
        validSet.add(r);
        validSet.add(c);
        validSet.add(b);
        return true;
    }
    /**
     * 每个数字分别存储三次，分别为所在行、列、块
     * 如input[1][2]=2 则为r12、c22、b002
     * @param board
     * @return
     */
    private boolean validInput(int[][] board) {
        validSet.clear();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int c = board[i][j];
                if (c == 0) {
                    continue;
                }
                String row = "r" + i + c;
                String col = "c" + j + c;
                String block = "b" + i / 3 + j / 3 + c;
                if (!validSet.add(row) || !validSet.add(col) || !validSet.add(block)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        boolean solve = new Sudoku().solve(a);
        System.out.println("has sovle ? "+solve);
        if (solve) {
            printMatrix(a);
        }
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        for (int[] i : matrix) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();

    }
}
