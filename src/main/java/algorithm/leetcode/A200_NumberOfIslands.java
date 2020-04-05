package algorithm.leetcode;

public class A200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    change(grid, i, j);
                    j++;
                }
            }
        }
        return res;
    }

    private void change(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            if (i - 1 >= 0) {
                change(grid, i - 1, j);
            }
            if (j - 1 >= 0) {
                change(grid, i, j - 1);
            }
            if (j + 1 < grid[0].length) {
                change(grid, i, j + 1);
            }
            if (i + 1 < grid.length) {
                change(grid, i + 1, j);
            }
        }
    }
}
