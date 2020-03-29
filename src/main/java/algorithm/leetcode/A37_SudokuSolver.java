package algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A37_SudokuSolver {
    static char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void solveSudoku(char[][] board) {
        validSet.clear();
        if (!validInput(board)) {
            return;
        }
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int i, int j) {
        if (j == 9) {
            return solveSudoku(board, i + 1, 0);
        }
        if (i == 9) {
            return true;
        }
        if (board[i][j] != '.') {
            return solveSudoku(board, i, j + 1);
        }
        for (char k : chars) {
            if (!isValid(i, j, k)) {
                continue;
            }
            board[i][j] = k;
            boolean b = solveSudoku(board, i, j + 1);
            if (b) {
                return b;
            }
            board[i][j] = '.';
            removeNum(i, j, k);
        }
        return false;
    }

    private void removeNum(int i, int j, char c) {
        validSet.remove("r" + i + c);
        validSet.remove("c" + j + c);
        validSet.remove("b" + (i / 3) + (j / 3) + c);
    }

    private Set<String> validSet = new HashSet<>();

    private boolean isValid(int row, int col, char ch) {
        String r = "r" + row + ch;
        String c = "c" + col + ch;
        String b = "b" + (row / 3) + (col / 3) + ch;
        if (validSet.contains(r) || validSet.contains(c) || validSet.contains(b)) {
            return false;
        }
        validSet.add(r);
        validSet.add(c);
        validSet.add(b);
        return true;
    }

    private boolean validInput(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char t = board[i][j];
                if (t == '.') {
                    continue;
                }
                String r = "r" + i + t;
                String c = "c" + j + t;
                String b = "b" + (i / 3) + (j / 3) + t;
                if (!validSet.add(r) || !validSet.add(c) || !validSet.add(b)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] a = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new A37_SudokuSolver().solveSudoku(a);
        for (char[] c : a) {
            System.out.println(Arrays.toString(c));
        }
    }
}
