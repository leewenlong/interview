package algorithm.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class A52_NQueensII {
    public int totalNQueens(int n) {
        if (n<=0){
            return 0;
        }
        char[][] temp = new char[n][n];
        AtomicInteger res = new AtomicInteger(0);
        backtrack(temp,res,0,n);
        return res.get();
    }

    private void backtrack(char[][] temp, AtomicInteger res, int i, int n) {
        if (i==n){
            res.incrementAndGet();
            return;
        }
        for (int j = 0; j < n; j++) {
            if(!isValid(temp,i,j,n)){
                continue;
            }
            temp[i][j] = 'Q';
            backtrack(temp,res,i+1,n);
            temp[i][j] ='\0';
        }
    }

    private boolean isValid(char[][] temp, int i, int j, int n) {
        for (int k = 0; k < n; k++) {
            if (temp[i][k] == 'Q' && k!=j ){
                return false;
            }
            if (temp[k][j] == 'Q' && k!=i ){
                return false;
            }
        }

        int r = i;
        int c = j;
        while (r>0&&c>0){
            if (temp[r-1][c-1]=='Q'){
                return false;
            }
            r--;
            c--;
        }
        while (i>0&&j<n-1){
            if (temp[i-1][j+1] == 'Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

}
