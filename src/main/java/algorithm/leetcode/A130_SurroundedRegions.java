package algorithm.leetcode;

public class A130_SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null||board.length ==0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i==0||j==0||i==row-1||j==col-1){
                    setBorder(board,i,j);
                }
            }
        }
        for (int i = 1; i < row-1; i++) {
            for (int j = 1; j < col-1; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] =='*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void setBorder(char[][] board, int i, int j) {
        if (board[i][j] == 'O'){
            board[i][j] = '*';
            int row = board.length;
            int col = board[0].length;
            if (j+1<col){
                setBorder(board,i,j+1);
            }
            if (j-1>=0){
                setBorder(board,i,j-1);
            }
            if (i-1>=0){
                setBorder(board,i-1,j);
            }
            if (i+1<row){
                setBorder(board,i+1,j);
            }
        }
    }
}
