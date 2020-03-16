package interview.offer;

import java.util.ArrayList;

public class ClockwisePrintMatrix {

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
     * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * @param matrix
     * @return
     * 两种方式：递归循环，非递归循环
     */
    //递归实现
//    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null||matrix.length==0) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        printMatrix0(matrix,0,result);
        return result;
    }

    private void printMatrix0(int[][] matrix, int start,ArrayList<Integer> result) {
        int endX = matrix[0].length - 1 - start;
        int endY = matrix.length - 1 - start;
        if (start > endX || start > endY) {
            return;
        }
        if (endX == start) {//1 列
            for (int i = start; i <= endY; i++) {
                result.add(matrix[i][start]);
            }
            return;
        }
        if (endY == start) {//1 行
            for (int i = start; i <= endX; i++) {
                result.add(matrix[start][i]);
            }
            return;
        }

        for (int i = start; i <= endX; i++) {//开始行
            result.add(matrix[start][i]);
        }
        for (int i = start + 1; i <= endY; i++) {//结束列
            result.add(matrix[i][endX]);
        }
        for (int i = endX - 1; i >= start; i--) {//结束行
            result.add(matrix[endY][i]);
        }
        for (int i = endY - 1; i > start; i--) {//开始列
            result.add(matrix[i][start]);
        }
        printMatrix0(matrix, start + 1,result);
    }

    /**
     * 非递归循环实现
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix_Ans1(int [][] matrix) {
        if (matrix == null||matrix.length==0) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int x = matrix[0].length;
        int y = matrix.length;
        int a = 0;//x point
        int b = 0;//y point
        while (a < x && b < y) {
            for (int i = a; i < x; i++) {
                result.add(matrix[a][i]);
            }
            b++;
            for (int i = b; i < y; i++) {
                result.add(matrix[i][x - 1]);
            }
            x--;
            if (b < y) {
                for (int i = x - 1; i >= a; i--) {
                    result.add(matrix[y - 1][i]);
                }
                y--;
            }
            if (a < x) {
                for (int i = y - 1; i >= b; i--) {
                    result.add(matrix[i][a]);
                }
                a++;
            }
        }
        return result;
    }
}
