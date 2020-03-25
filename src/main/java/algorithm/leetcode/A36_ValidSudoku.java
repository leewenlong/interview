package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class A36_ValidSudoku {
    private Set<Character> set = new HashSet<>();
    public boolean isValidSudoku(char[][] board) {

        if (!validRow(board)){
            return false;
        }
        if (!validCol(board)){
            return false;
        }

        for (int i = 0; i < 9; i=i+3) {
            for (int j = 0; j < 9; j=j+3) {
                if (!validNine(board,i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    //每个数字按行列块分别拼接字符串放到set中
    // 比如 r03,c41,b110分别代表第0行有个3，第4列有个1，第(1,1)个块有个0
    public boolean isValidSudokuII(char[][] board) {
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                String row = "r" + i + c;
                String col = "c" + j + c;
                String block = "b" + i / 3 + j / 3 + c;
                if (!hashSet.add(row) || !hashSet.add(col) || !hashSet.add(block)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validRow(char[][] board) {
        set.clear();
        for (char[] chars : board) {
            for (char c : chars) {
                if (set.contains(c)){
                    return false;
                }else if (c != '.'){
                    set.add(c);
                }

            }
            set.clear();
        }
        return true;
    }

    private boolean validCol(char[][] board) {
        set.clear();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (set.contains(c)){
                    return false;
                }else if (c != '.'){
                    set.add(c);
                }
            }
            set.clear();
        }
        return true;
    }
    private boolean validNine(char[][] board,int x,int y) {
        set.clear();
        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y+3; j++) {
                char c = board[i][j];
                if (set.contains(c)){
                    return false;
                }else if (c != '.'){
                    set.add(c);
                }
            }
        }
        set.clear();
        return true;
    }
}
