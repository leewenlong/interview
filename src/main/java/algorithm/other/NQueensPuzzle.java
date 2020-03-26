package algorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensPuzzle {

    private List<int[][]> nQ = new ArrayList<>();

    public List<int[][]> nQueen(int n) {
        nQ.clear();
        int[][] tempAns = new int[n][n];
        backtrack(tempAns, 0, n);
        return nQ;
    }

    private void backtrack(int[][] temp, int row, int num) {
        if (num == row) {
            int[][] t = new int[num][num];
            copyMatrix(temp, t);
            nQ.add(t);
        } else {
            for (int i = 0; i < num; i++) {//col
                if (!isValid(temp, row, i)) {
                    continue;
                }
                temp[row][i] = 1;
                backtrack(temp, row + 1, num);
                temp[row][i] = 0;
            }
        }
    }

    private void copyMatrix(int[][] from, int[][] to) {
        for (int i = 0; i < from.length; i++) {
            System.arraycopy(from[i], 0, to[i], 0, from[i].length);
        }
    }

    //其实只要检测（row,col）之前的数据即可，之后的数据都是0
    private boolean isValid(int[][] matrix, int row, int col) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[row][i] == 1 && col != i) {//valid col
                return false;
            }
            if (matrix[i][col] == 1 && i != row) {
                return false;//valid row
            }
        }
        for (int i = row-1, j = col-1 ; i >=0 && j>=0; i--,j--) {
            if (matrix[i][j] == 1){//left up
                return false;
            }
        }
        for (int i = row-1 ,j = col+1; i >=0 && j<n ; i--,j++) {
            if (matrix[i][j] == 1){//right up
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueensPuzzle q = new NQueensPuzzle();

        List<int[][]> nQueue = q.nQueen(8);
        for (int[][] listList : nQueue) {
            printMatrix(listList);
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
