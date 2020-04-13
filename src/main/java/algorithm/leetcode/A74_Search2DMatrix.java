package algorithm.leetcode;

public class A74_Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
            return false;
        }
        int left = 0;
        int mid = row / 2;
        int right = row - 1;
        while (left <= right) {
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        int i = right;
        left = 0;
        mid = col / 2;
        right = col - 1;
        while (left <= right) {
            if (matrix[i][mid] == target) {
                return true;
            } else if (matrix[i][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return false;
    }

    public boolean searchMatrixII(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
            return false;
        }
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = (left+right) / 2;
            int i = mid / col;
            int j = mid % col;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
