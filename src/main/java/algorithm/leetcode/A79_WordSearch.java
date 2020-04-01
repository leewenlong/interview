package algorithm.leetcode;

public class A79_WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, char[] chars, int k) {
        if (k == chars.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != chars[k]) {
            return false;
        }
        board[i][j] = '\0';//设置为空，不允许再次返回
        boolean ex = exist(board, i, j + 1, chars, k + 1) ||
                exist(board, i + 1, j, chars, k + 1) ||
                exist(board, i, j - 1, chars, k + 1) ||
                exist(board, i - 1, j, chars, k + 1);
        if (ex) {
            return true;
        }
        board[i][j] = chars[k];//不满足，还原位置
        return false;

    }
}
